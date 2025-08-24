package com.DescomplicandoIngles.DescomplicandoIngles.service.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

    private String message;
    private int status;
    private LocalDateTime timestamp;
    private String error;
    private String uri;

    public ErrorResponse(String message, int status, LocalDateTime timestamp, String error, String uri) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.error = error;
        this.uri = uri;
    }

   public String getMessage() {
       return message;
   }

   public void setMessage(String message) {
       this.message = message;
   }

   public int getStatus() {
       return status;
   }

   public void setStatus(int status) {
       this.status = status;
   }

   public LocalDateTime getTimestamp() {
       return timestamp;
   }

   public void setTimestamp(LocalDateTime timestamp) {
       this.timestamp = timestamp;
   }

   public String getError() {
       return error;
   }

   public void setError(String error) {
       this.error = error;
   }

   public String getUri() {
       return uri;
   }

   public void setUri(String uri) {
       this.uri = uri;
   }

}
