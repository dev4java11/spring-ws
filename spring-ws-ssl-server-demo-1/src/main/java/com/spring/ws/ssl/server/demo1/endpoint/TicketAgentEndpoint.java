package com.spring.ws.ssl.server.demo1.endpoint;

import java.math.BigInteger;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.spring.ws.ssl.server.demo1.ticketagent.ObjectFactory;
import com.spring.ws.ssl.server.demo1.ticketagent.TFlightsResponse;
import com.spring.ws.ssl.server.demo1.ticketagent.TListFlights;

@Endpoint
public class TicketAgentEndpoint {

  @PayloadRoot(namespace = "http://example.org/TicketAgent.xsd", localPart = "listFlightsRequest")
  @ResponsePayload
  public JAXBElement<TFlightsResponse> listFlights(@RequestPayload JAXBElement<TListFlights> request) {

    ObjectFactory factory = new ObjectFactory();
    TFlightsResponse tFlightsResponse = factory.createTFlightsResponse();
    tFlightsResponse.getFlightNumber().add(BigInteger.valueOf(101));

    return factory.createListFlightsResponse(tFlightsResponse);
  }
}