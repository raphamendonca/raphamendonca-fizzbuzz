package com.github.raphamendonca.raphamendoncafizzbuzz.exceptionhandler;

import org.springframework.http.HttpStatus;

public class ResponseError {

	    private HttpStatus status;
	    private int code;
	    private String message;
	    private String detail;
	        
	    public HttpStatus getStatus() {
			return status;
		}

		public int getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

		public String getDetail() {
			return detail;
		}

		public void setStatus(HttpStatus status) {
			this.status = status;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public void setDetail(String detail) {
			this.detail = detail;
		}

		public static final class ResponseErrorBuilder {
	        private HttpStatus status;
	        private int code;
	        private String message;
	        private String detail;

	        ResponseErrorBuilder() {
	        }

	        public static ResponseErrorBuilder anResponseError() {
	            return new ResponseErrorBuilder();
	        }

	        public ResponseErrorBuilder withStatus(HttpStatus status) {
	            this.status = status;
	            return this;
	        }

	        public ResponseErrorBuilder withCode(int i) {
	            this.code = i;
	            return this;
	        }

	        public ResponseErrorBuilder withMessage(String message) {
	            this.message = message;
	            return this;
	        }

	        public ResponseErrorBuilder withDetail(String detail) {
	            this.detail = detail;
	            return this;
	        }

	        public ResponseError build() {
	            ResponseError responseError = new ResponseError();
	            responseError.status = this.status;
	            responseError.code = this.code;
	            responseError.detail = this.detail;
	            responseError.message = this.message;
	            return responseError;
	        }
	    }
	
}
