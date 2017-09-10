package com.spring.ws.ssl.client.demo1.client;

import java.math.BigInteger;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.spring.ws.ssl.client.demo1.ticketagent.ObjectFactory;
import com.spring.ws.ssl.client.demo1.ticketagent.TFlightsResponse;
import com.spring.ws.ssl.client.demo1.ticketagent.TListFlights;

@Component
public class TicketAgentClient {

  @Autowired
  private WebServiceTemplate webServiceTemplate;

  @SuppressWarnings("unchecked")
  public List<BigInteger> listFlights() {
    ObjectFactory factory = new ObjectFactory();
    TListFlights tListFlights = factory.createTListFlights();
    JAXBElement<TListFlights> request = factory.createListFlightsRequest(tListFlights);
    JAXBElement<TFlightsResponse> response = (JAXBElement<TFlightsResponse>) webServiceTemplate.marshalSendAndReceive(request);
    return response.getValue().getFlightNumber();
  }
}