package com.pharmacy.code.service;

import java.util.*;

import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.pharmacy.code.billing.entity.BillReceivable;
import com.pharmacy.code.billing.entity.BillReceivableDetails;
import com.pharmacy.code.billing.entity.CashReceipt;
import com.pharmacy.code.billing.repository.BillingRepository;
import com.pharmacy.code.billing.repository.CashReceiptRepository;
import com.pharmacy.code.billing.service.BillReceivableService;
import com.pharmacy.code.billing.service.CashReceiptService;
import com.pharmacy.code.dto.OrderRequest;
import com.pharmacy.code.dto.OrderResponse;
import com.pharmacy.code.entity.OrderDetails;
import com.pharmacy.code.entity.OrderInfo;
import com.pharmacy.code.repository.OrderRepository;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;	

	private BillReceivableService billReceivableService;

	private CashReceiptService cashReceiptService;

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository, 
			BillReceivableService billReceivableService, 
			CashReceiptService cashReceiptService) {
		this.orderRepository = orderRepository;
		this.billReceivableService = billReceivableService;
		this.cashReceiptService = cashReceiptService;
	}

	@Override
	public OrderInfo findByOrderNumber(String orderNumber) {
		// TODO Auto-generated method stub
		return orderRepository.findByOrderNumber(orderNumber);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public OrderResponse save(OrderRequest orderRequest) {
		try {
			// TODO Auto-generated method stub
			String orderNumber = UUID.randomUUID().toString();
			String billNumber = UUID.randomUUID().toString();
			String transactionId = UUID.randomUUID().toString();

			BillReceivable billReceivable = this.createBillReceivable(orderRequest, billNumber, transactionId);
			billReceivable.setAmountPaid(orderRequest.getCashReceipt().getAmountPaid());

			OrderInfo orderInfo = this.createOrderInfo(orderRequest, orderNumber);

			CashReceipt cashReceipt = orderRequest.getCashReceipt();
			cashReceipt.setBillNumber(billNumber);
			cashReceipt.setTransactionId(transactionId);
			cashReceipt.setReceivedBy("Admin");
			cashReceipt.setReceivedDate(new Date());

			orderRequest.getOrderInfo().setTransactionId(transactionId);
			orderRequest.getOrderInfo().setBillNumber(billNumber);
			orderRequest.getOrderInfo().setAmountPaid(billReceivable.getAmountPaid());

			Random random = new Random(10000);
			orderRequest.getOrderInfo().setSequenceNumber(String.valueOf(random.nextInt()));

			OrderInfo orderInfoResponse = orderRepository.save(orderRequest.getOrderInfo());
			BillReceivable billReceivableResponse = billReceivableService.save(billReceivable);
			CashReceipt cashReceiptResponse = cashReceiptService.save(cashReceipt);

			OrderResponse orderResponse = new OrderResponse();
			orderResponse.setOrderResponse(orderInfoResponse);
			orderResponse.setBillReceivableResponse(billReceivableResponse);
			orderResponse.setCashReceiptResponse(cashReceiptResponse);

			return orderResponse;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public OrderInfo update(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		return orderRepository.save(orderInfo);
	}

	public List<BillReceivableDetails> createBillReceivableDetails(List<OrderDetails> orderDetailsList, String transactionId) {

		List<BillReceivableDetails> detaitsList = new ArrayList<BillReceivableDetails>();

		for (OrderDetails detail: orderDetailsList) {
			BillReceivableDetails billDetails = new BillReceivableDetails();
			billDetails.setServiceCode(detail.getDrugId());
			billDetails.setServiceName(detail.getDrugName());

			billDetails.setHsnCode(detail.getHsnCode());
			billDetails.setQuantity(detail.getQuantity());
			billDetails.setUnitPrice(detail.getUnitPrice());
			billDetails.setTotalPrice(detail.getTotalPrice());
			billDetails.setDiscountAmount(detail.getDiscountAmount());
			billDetails.setDiscountPerc(detail.getDiscountPerc());
			billDetails.setSgst(detail.getSgst());
			billDetails.setCgst(detail.getCgst());

			Double totals = (detail.getTotalPrice() - detail.getDiscountAmount());
			Double taxes = (totals * detail.getCgst() / 100) + (totals * detail.getSgst() / 100);
			billDetails.setNetAmount(totals + taxes);
			billDetails.setTransactionId(transactionId);

			detail.setBillReceivableDetailsId(billDetails.getId());

			detaitsList.add(billDetails);
		}

		return detaitsList;
	}

	public BillReceivable createBillReceivable(OrderRequest orderRequest, String billNumber, String transactionId) {
		BillReceivable billReceivable = new BillReceivable();

		billReceivable.setBillNumber(billNumber);
		billReceivable.setBillDate(new Date());
		billReceivable.setCreatedBy("admin");

		billReceivable.setLastModifiedBy("admin");
		billReceivable.setStatus(orderRequest.getOrderStatus());

	 	List<BillReceivableDetails> detailList = this.createBillReceivableDetails(orderRequest.getOrderItems(), transactionId);
		billReceivable.setBillReceivableDetails(detailList);

		Iterator<BillReceivableDetails> detailItr =  billReceivable.getBillReceivableDetails().iterator();
		Double totalAmountPaid = 0.00d;
		while (detailItr.hasNext()) {
			BillReceivableDetails details = detailItr.next();
			totalAmountPaid += details.getNetAmount();
		}

		billReceivable.setAmountPaid(totalAmountPaid);
		billReceivable.setDueAmount(orderRequest.getDueAmount());
		billReceivable.setStatus("A");
		return billReceivable;
	}

	public OrderInfo createOrderInfo(OrderRequest orderRequest, String orderNumber) {
		OrderInfo orderInfo = orderRequest.getOrderInfo();
		orderInfo.setUhid(orderRequest.getUhid());
		orderInfo.setOrderNumber(orderNumber);

		orderInfo.setOrderDetails(orderRequest.getOrderItems());

		return orderInfo;
	}
}
