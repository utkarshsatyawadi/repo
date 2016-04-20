package com.satyawadi.ws.endpoint;

import org.jdom2.Element;
import org.jdom2.xpath.XPathExpression;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.satyawadi.ws.service.WSService;

@Endpoint
public class WSEndpoint {

	private static final String NAMESPACE_URI = "http://webservice.com/wsspring/schemas";

	private XPathExpression<String> nameExpression;

	private WSService wsService;

	/*@Autowired
	public WSEndpoint(WSService wsService)
			throws JDOMException, XPathFactoryConfigurationException,
			XPathExpressionException {
		this.wsService = wsService;

		Namespace namespace = Namespace.getNamespace("wsspring", NAMESPACE_URI);

		XPathFactory xPathFactory = XPathFactory.instance();

		this.nameExpression = xPathFactory.compile("//wsspring:Name", Filters.fstring(), null, namespace);
	}*/

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "WSRequest")
	@ResponsePayload
	public Element handleWSRequest(@RequestPayload Element wsRequest)
			throws Exception {
		String name = wsRequest.getAttribute("Name").getValue();
		String message = this.wsService.hello(name);
		Element response = new Element("WSTest");
		response.setAttribute("Message", message);
		return response;
	}

}
