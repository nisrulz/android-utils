/*
 * Copyright (C) 2016 Nishant Srivastava
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package github.nisrulz.androidutils.network;

/**
 * The type Http response util.
 */
public class HTTPResponseUtil {

    private final HTTPResponseInfo httpResponseInfo;

    /**
     * Instantiates a new Http response util.
     */
    public HTTPResponseUtil() {
        this.httpResponseInfo = new HTTPResponseInfo();
    }

    /**
     * Gets info.
     *
     * @param statusCode the status code
     * @return the info
     */
    public HTTPResponseInfo getInfo(int statusCode) {
    /* Http Code data reference from : https://developer.mozilla.org/en-US/docs/Web/HTTP/Status */
        httpResponseInfo.setStatusCode(statusCode);

        switch (statusCode) {
            case 100: {
                httpResponseInfo.setType("Information Response");
                httpResponseInfo.setStatusText("Continue");
                httpResponseInfo.setStatusDescription(
                        "This interim response indicates that everything so far is OK and that the client should continue with the request or ignore it if it is already finished");
                break;
            }
            case 101: {
                httpResponseInfo.setType("Information Response");
                httpResponseInfo.setStatusText("Switching Protocol");
                httpResponseInfo.setStatusDescription(
                        "This code is sent in response to an Upgrade: request header by the client, and indicates that the protocol the server is switching too. It was introduced to allow migration to an incompatible protocol version, and is not in common use");
                break;
            }
            case 200: {
                httpResponseInfo.setType("Successful Response");
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
                httpResponseInfo.setType("Successful Response");
                httpResponseInfo.setStatusText("Created");
                httpResponseInfo.setStatusDescription(
                        "The request has succeeded and a new resource has been created as a result of it. This is typically the response sent after a PUT request");
                break;
            }
            case 202: {
                httpResponseInfo.setType("Successful Response");
                httpResponseInfo.setStatusText("Accepted");
                httpResponseInfo.setStatusDescription("\n"
                        + "The request has been received but not yet acted upon. It is non-committal, meaning that there is no way in HTTP to later send an asynchronous response indicating the outcome of processing the request. It is intended for cases where another process or server handles the request, or for batch processing");
                break;
            }
            case 203: {
                httpResponseInfo.setType("Successful Response");
                httpResponseInfo.setStatusText("Non-Authoritative Information");
                httpResponseInfo.setStatusDescription(
                        "This response code means returned meta-information set is not exact set as available from the origin server, but collected from a local or a third party copy. Except this condition, 200 OK response should be preferred instead of this response");
                break;
            }
            case 204: {
                httpResponseInfo.setType("Successful Response");
                httpResponseInfo.setStatusText("No Content");
                httpResponseInfo.setStatusDescription(
                        "There is no content to send for this request, but the headers may be useful. The user-agent may update its cached headers for this resource with the new ones");
                break;
            }
            case 205: {
                httpResponseInfo.setType("Successful Response");
                httpResponseInfo.setStatusText("Reset Content");
                httpResponseInfo.setStatusDescription(
                        "This response code is sent after accomplishing request to tell user agent reset document view which sent this request");
                break;
            }
            case 206: {
                httpResponseInfo.setType("Successful Response");
                httpResponseInfo.setStatusText("Partial Content");
                httpResponseInfo.setStatusDescription(
                        "This response code is used because of range header sent by the client to separate download into multiple streams");
                break;
            }
            case 300: {
                httpResponseInfo.setType("Redirection Message");
                httpResponseInfo.setStatusText("Multiple Choice");
                httpResponseInfo.setStatusDescription(
                        "The request has more than one possible responses. User-agent or user should choose one of them. There is no standardized way to choose one of the Response");
                break;
            }
            case 301: {
                httpResponseInfo.setType("Redirection Message");
                httpResponseInfo.setStatusCode(statusCode);
                httpResponseInfo.setStatusText("Moved Permanently");
                httpResponseInfo.setStatusDescription(
                        "This response code means that URI of requested resource has been changed. Probably, new URI would be given in the response");
                break;
            }
            case 302: {
                httpResponseInfo.setType("Redirection Message");
                httpResponseInfo.setStatusText("Found");
                httpResponseInfo.setStatusDescription(
                        "This response code means that URI of requested resource has been changed temporarily. New changes in the URI might be made in the future. Therefore, this same URI should be used by the client in future requests");
                break;
            }
            case 303: {
                httpResponseInfo.setType("Redirection Message");
                httpResponseInfo.setStatusText("See Other");
                httpResponseInfo.setStatusDescription(
                        "Server sent this response to directing client to get requested resource to another URI with an GET request");
                break;
            }
            case 304: {
                httpResponseInfo.setType("Redirection Message");
                httpResponseInfo.setStatusCode(statusCode);
                httpResponseInfo.setStatusText("Not Modified");
                httpResponseInfo.setStatusDescription(
                        "This is used for caching purposes. It is telling to client that response has not been modified. So, client can continue to use same cached version of response");
                break;
            }
            case 305: {
                httpResponseInfo.setType("Redirection messages");
                httpResponseInfo.setStatusText("Use Proxy");
                httpResponseInfo.setStatusDescription(
                        "This means requested response must be accessed by a proxy. This response code is not largely supported because security reasons");
                break;
            }
            case 306: {
                httpResponseInfo.setType("Redirection Message");
                httpResponseInfo.setStatusText("unused");
                httpResponseInfo.setStatusDescription(
                        "This response code is no longer used, it is just reserved currently. It was used in a previous version of the HTTP 1.1 specification");
                break;
            }
            case 307: {
                httpResponseInfo.setType("Redirection Message");
                httpResponseInfo.setStatusText("Temporary Redirect");
                httpResponseInfo.setStatusDescription(
                        "Server sent this response to directing client to get requested resource to another URI with same method that used prior request. This has the same semantic than the 302 Found HTTP response code, with the exception that the user agent must not change the HTTP method used: if a POST was used in the first request, a POST must be used in the second request");
                break;
            }
            case 308: {
                httpResponseInfo.setType("Redirection Message");
                httpResponseInfo.setStatusText("Permanent Redirect");
                httpResponseInfo.setStatusDescription(
                        "This means that the resource is now permanently located at another URI, specified by the Location: HTTP Response header. This has the same semantics as the 301 Moved Permanently HTTP response code, with the exception that the user agent must not change the HTTP method used: if a POST was used in the first request, a POST must be used in the second request");
                break;
            }

            case 400: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Bad Request");
                httpResponseInfo.setStatusDescription(
                        "This response means that server could not understand the request due to invalid syntax");
                break;
            }
            case 401: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusCode(statusCode);
                httpResponseInfo.setStatusText("Unauthorized");
                httpResponseInfo.setStatusDescription(
                        "Authentication is needed to get requested response. This is similar to 403, but in this case, authentication is possible");
                break;
            }
            case 402: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Payment Required");
                httpResponseInfo.setStatusDescription(
                        "This response code is reserved for future use. Initial aim for creating this code was using it for digital payment systems however this is not used currently");
                break;
            }
            case 403: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Forbidden");
                httpResponseInfo.setStatusDescription(
                        "Client does not have access rights to the content so server is rejecting to give proper response");
                break;
            }
            case 404: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Not Found");
                httpResponseInfo.setStatusDescription(
                        "Server can not find requested resource. This response code probably is most famous one due to its frequency to occur in web");
                break;
            }
            case 405: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Method Not Allowed");
                httpResponseInfo.setStatusDescription(
                        "The request method is known by the server but has been disabled and cannot be used. The two mandatory methods, GET and HEAD, must never be disabled and should not return this error code");
                break;
            }
            case 406: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Not Acceptable");
                httpResponseInfo.setStatusDescription(
                        "This response is sent when the web server, after performing server-driven content negotiation, doesn't find any content following the criteria given by the user agent");
                break;
            }
            case 407: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Proxy Authentication Required");
                httpResponseInfo.setStatusDescription(
                        "This is similar to 401 but authentication is needed to be done by a proxy.");
                break;
            }
            case 408: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Request Timeout");
                httpResponseInfo.setStatusDescription(
                        "This response is sent on an idle connection by some servers, even without any previous request by the client. It means that the server would like to shut down this unused connection. This response is used much more since some browsers, like Chrome or IE9, use HTTP pre connection mechanisms to speed up surfing (see bug 881804, which tracks the future implementation of such a mechanism in Firefox). Also note that some servers merely shut down the connection without sending this message");
                break;
            }
            case 409: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Conflict");
                httpResponseInfo.setStatusDescription(
                        "This response would be sent when a request conflict with current state of server");
                break;
            }
            case 410: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Gone");
                httpResponseInfo.setStatusDescription(
                        "This response would be sent when requested content has been deleted from server");
                break;
            }
            case 411: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Length Required");
                httpResponseInfo.setStatusDescription(
                        "Server rejected the request because the Content-Length header field is not defined and the server requires it");
                break;
            }
            case 412: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Precondition Failed");
                httpResponseInfo.setStatusDescription(
                        "The client has indicated preconditions in its headers which the server does not meet");
                break;
            }
            case 413: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Payload Too Large");
                httpResponseInfo.setStatusDescription(
                        "Request entity is larger than limits defined by server; the server might close the connection or return an Retry-After header field");
                break;
            }
            case 414: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("URI Too Long");
                httpResponseInfo.setStatusDescription(
                        "The URI requested by the client is longer than the server is willing to interpret");
                break;
            }
            case 415: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Unsupported Media Type");
                httpResponseInfo.setStatusDescription(
                        "The media format of the requested data is not supported by the server, so the server is rejecting the request");
                break;
            }
            case 416: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Requested Range Not Satisfiable");
                httpResponseInfo.setStatusDescription(
                        "The range specified by the Range header field in the request can't be fulfilled; it's possible that the range is outside the size of the target URI's data");
                break;
            }
            case 417: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Expectation Failed");
                httpResponseInfo.setStatusDescription(
                        "This response code means the expectation indicated by the Expect request header field can't be met by the server");
                break;
            }
            case 421: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Misdirected Request");
                httpResponseInfo.setStatusDescription(
                        "The request was directed at a server that is not able to produce a response. This can be sent by a server that is not configured to produce responses for the combination of scheme and authority that are included in the request URI");
                break;
            }
            case 426: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Upgrade Required");
                httpResponseInfo.setStatusDescription(
                        "The server refuses to perform the request using the current protocol but might be willing to do so after the client upgrades to a different protocol. The server MUST send an Upgrade header field in a 426 response to indicate the required protocol(s)");
                break;
            }
            case 428: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Precondition Required");
                httpResponseInfo.setStatusDescription(
                        "The origin server requires the request to be conditional. Intended to prevent \"the 'lost update' problem, where a client GETs a resource's state, modifies it, and PUTs it back to the server, when meanwhile a third party has modified the state on the server, leading to a conflict");
                break;
            }
            case 429: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Too Many Requests");
                httpResponseInfo.setStatusDescription(
                        "The user has sent too many requests in a given amount of time (\"rate limiting\")");
                break;
            }
            case 431: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Request Header Fields Too Large");
                httpResponseInfo.setStatusDescription(
                        "The server is unwilling to process the request because its header fields are too large. The request MAY be resubmitted after reducing the size of the request header fields");
                break;
            }

            case 451: {
                httpResponseInfo.setType("Client Error Response");
                httpResponseInfo.setStatusText("Unavailable For Legal Reasons");
                httpResponseInfo.setStatusDescription(
                        "The user requests an illegal resource, such as a web page censored by a government");
                break;
            }

            case 500: {
                httpResponseInfo.setType("Server Error Response");
                httpResponseInfo.setStatusText("Internal Server Error");
                httpResponseInfo.setStatusDescription(
                        "The server has encountered a situation it doesn't know how to handle");
                break;
            }
            case 501: {
                httpResponseInfo.setType("Server Error Response");
                httpResponseInfo.setStatusText("Not Implemented");
                httpResponseInfo.setStatusDescription(
                        "The request method is not supported by the server and cannot be handled. The only methods that servers are required to support (and therefore that must not return this code) are GET and HEAD");
                break;
            }
            case 502: {
                httpResponseInfo.setType("Server Error Response");
                httpResponseInfo.setStatusText("Bad Gateway");
                httpResponseInfo.setStatusDescription(
                        "This error response means that the server, while working as a gateway to get a response needed to handle the request, got an invalid response");
                break;
            }
            case 503: {
                httpResponseInfo.setType("Server Error Response");
                httpResponseInfo.setStatusText("Service Unavailable");
                httpResponseInfo.setStatusDescription(
                        "The server is not ready to handle the request. Common causes are a server that is down for maintenance or that is overloaded. Note that together with this response, a user-friendly page explaining the problem should be sent. This responses should be used for temporary conditions and the Retry-After: HTTP header should, if possible, contain the estimated time before the recovery of the service. The webmaster must also take care about the caching-related headers that are sent along with this response, as these temporary condition responses should usually not be cached");
                break;
            }
            case 504: {
                httpResponseInfo.setType("Server error response");
                httpResponseInfo.setStatusText("Gateway Timeout");
                httpResponseInfo.setStatusDescription(
                        "This error response is given when the server is acting as a gateway and cannot get a response in time");
                break;
            }
            case 505: {
                httpResponseInfo.setType("Server Error Response");
                httpResponseInfo.setStatusText("HTTP Version Not Supported");
                httpResponseInfo.setStatusDescription(
                        "The HTTP version used in the request is not supported by the server");
                break;
            }
            case 506: {
                httpResponseInfo.setType("Server Error Response");
                httpResponseInfo.setStatusText("Variant Also Negotiates");
                httpResponseInfo.setStatusDescription(
                        "The server has an internal configuration error: transparent content negotiation for the request results in a circular reference");
                break;
            }
            case 507: {
                httpResponseInfo.setType("Server Error Response");
                httpResponseInfo.setStatusText("Variant Also Negotiates");
                httpResponseInfo.setStatusDescription(
                        "The server has an internal configuration error: the chosen variant resource is configured to engage in transparent content negotiation itself, and is therefore not a proper end point in the negotiation process");
                break;
            }
            case 511: {
                httpResponseInfo.setType("Server Error Response");
                httpResponseInfo.setStatusText("Network Authentication Required");
                httpResponseInfo.setStatusDescription(
                        "The 511 status code indicates that the client needs to authenticate to gain network access");
                break;
            }

            default:
                // Do not set anything
                break;
        }

        return httpResponseInfo;
    }
}
