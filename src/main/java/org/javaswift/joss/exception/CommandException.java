package org.javaswift.joss.exception;

import java.util.HashMap;
import java.util.Map;

public class CommandException extends RuntimeException {

    private int httpStatusCode;
    private Map<String,String> httpHeaders = new HashMap<String,String>();
    private CommandExceptionError error;

    public CommandException(Integer httpStatusCode, CommandExceptionError error) {
        this.httpStatusCode = httpStatusCode;
        this.error = error;
    }

    public CommandException(String message) {
        super(message);
    }

    public CommandException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

   public void addHttpHeaderField(String name, String value) {
      this.httpHeaders.put(name, value);
   }

   public Map<String,String> getHttpHeaders() {
      return httpHeaders;
   }
   
    public CommandExceptionError getError() {
        return this.error;
    }

    public String toString() {
        return httpStatusCode != 0 && error != null ?
            "Command exception, HTTP Status code: "+httpStatusCode+" => " + error :
            super.toString();
    }
}
