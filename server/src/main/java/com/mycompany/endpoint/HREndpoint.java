package com.mycompany.endpoint;

import com.mycompany.repository.ResponseRepository;
import hr.wsdl.HolidayRequest;
import hr.wsdl.HolidayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HREndpoint {
	private static final String NAMESPACE_URI = "http://mycompany.com/hr/schemas";

	private ResponseRepository hrRepository;

	@Autowired
	public HREndpoint(ResponseRepository responseRepository) {
		this.hrRepository = responseRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "HolidayRequest")
	@ResponsePayload
	public HolidayResponse getHolidayRequest(@RequestPayload HolidayRequest request) {
        HolidayResponse response = new HolidayResponse();
		response.setResponse(hrRepository.processHolidayRequest(request));

        return response;
	}
}