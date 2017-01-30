package github.nisrulz.androidutils.network;

public class HTTPResponseUtil {

  private HTTPResponseInfo httpResponseInfo;

  public HTTPResponseUtil() {
    this.httpResponseInfo = new HTTPResponseInfo();
  }

  public HTTPResponseInfo getInfo(int statusCode) {
    /* Http Code data reference from : https://developer.mozilla.org/en-US/docs/Web/HTTP/Status */

    switch (statusCode) {
      case 100: {
        httpResponseInfo.setType("Information responses");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("Continue");
        httpResponseInfo.setStatusDescription(
            "This interim response indicates that everything so far is OK and that the client should continue with the request or ignore it if it is already finished");
        break;
      }
      case 101: {
        httpResponseInfo.setType("Information responses");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("Switching Protocol");
        httpResponseInfo.setStatusDescription(
            "This code is sent in response to an Upgrade: request header by the client, and indicates that the protocol the server is switching too. It was introduced to allow migration to an incompatible protocol version, and is not in common use");
        break;
      }
      case 200: {
        httpResponseInfo.setType("Successful responses");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("Ok");
        httpResponseInfo.setStatusDescription(
            "The request has succeeded. The meaning of a success varies depending on the HTTP method:\n"
                + "GET: The resource has been fetched and is transmitted in the message body.\n"
                + "HEAD: The entity headers are in the message body.\n"
                + "POST: The resource describing the result of the action is transmitted in the message body.\n"
                + "TRACE: The message body contains the request message as received by the server");
        break;
      }
      case 201: {
        httpResponseInfo.setType("Successful responses");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("Created");
        httpResponseInfo.setStatusDescription(
            "The request has succeeded and a new resource has been created as a result of it. This is typically the response sent after a PUT request");
        break;
      }
      case 202: {
        httpResponseInfo.setType("Successful responses");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("Accepted");
        httpResponseInfo.setStatusDescription("\n"
            + "The request has been received but not yet acted upon. It is non-committal, meaning that there is no way in HTTP to later send an asynchronous response indicating the outcome of processing the request. It is intended for cases where another process or server handles the request, or for batch processing");
        break;
      }
      case 203: {
        httpResponseInfo.setType("Successful responses");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("Non-Authoritative Information");
        httpResponseInfo.setStatusDescription("This response code means returned meta-information set is not exact set as available from the origin server, but collected from a local or a third party copy. Except this condition, 200 OK response should be preferred instead of this response");
        break;
      }
      case 204: {
        httpResponseInfo.setType("Successful responses");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("No Content");
        httpResponseInfo.setStatusDescription("There is no content to send for this request, but the headers may be useful. The user-agent may update its cached headers for this resource with the new ones");
        break;
      }
      case 205: {
        httpResponseInfo.setType("Successful responses");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("Reset Content");
        httpResponseInfo.setStatusDescription("This response code is sent after accomplishing request to tell user agent reset document view which sent this request");
        break;
      }
      case 206: {
        httpResponseInfo.setType("Successful responses");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("Partial Content");
        httpResponseInfo.setStatusDescription("This response code is used because of range header sent by the client to separate download into multiple streams");
        break;
      }
      case 300: {
        httpResponseInfo.setType("Redirection messages");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("Multiple Choice");
        httpResponseInfo.setStatusDescription("The request has more than one possible responses. User-agent or user should choose one of them. There is no standardized way to choose one of the responses");
        break;
      }
      case 301: {
        httpResponseInfo.setType("Redirection messages");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("Moved Permanently");
        httpResponseInfo.setStatusDescription("This response code means that URI of requested resource has been changed. Probably, new URI would be given in the response");
        break;
      }
      case 302: {
        httpResponseInfo.setType("Redirection messages");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("Found");
        httpResponseInfo.setStatusDescription("This response code means that URI of requested resource has been changed temporarily. New changes in the URI might be made in the future. Therefore, this same URI should be used by the client in future requests");
        break;
      }
      case 303: {
        httpResponseInfo.setType("Redirection messages");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("See Other");
        httpResponseInfo.setStatusDescription("Server sent this response to directing client to get requested resource to another URI with an GET request");
        break;
      }
      case 304: {
        httpResponseInfo.setType("Redirection messages");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("Not Modified");
        httpResponseInfo.setStatusDescription("This is used for caching purposes. It is telling to client that response has not been modified. So, client can continue to use same cached version of response");
        break;
      }
      case 305: {
        httpResponseInfo.setType("Redirection messages");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("Use Proxy");
        httpResponseInfo.setStatusDescription("This means requested response must be accessed by a proxy. This response code is not largely supported because security reasons");
        break;
      }
      case 306: {
        httpResponseInfo.setType("Redirection messages");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("unused");
        httpResponseInfo.setStatusDescription("This response code is no longer used, it is just reserved currently. It was used in a previous version of the HTTP 1.1 specification");
        break;
      }
      case 307: {
        httpResponseInfo.setType("Redirection messages");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("Temporary Redirect");
        httpResponseInfo.setStatusDescription("Server sent this response to directing client to get requested resource to another URI with same method that used prior request. This has the same semantic than the 302 Found HTTP response code, with the exception that the user agent must not change the HTTP method used: if a POST was used in the first request, a POST must be used in the second request");
        break;
      }
      case 308: {
        httpResponseInfo.setType("Redirection messages");
        httpResponseInfo.setStatusCode(statusCode);
        httpResponseInfo.setStatusText("Permanent Redirect");
        httpResponseInfo.setStatusDescription("This means that the resource is now permanently located at another URI, specified by the Location: HTTP Response header. This has the same semantics as the 301 Moved Permanently HTTP response code, with the exception that the user agent must not change the HTTP method used: if a POST was used in the first request, a POST must be used in the second request");
        break;
      }
      
      default:
        // Donot set anything
        break;
    }

    return httpResponseInfo;
  }
}
