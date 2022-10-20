package com.TTN.spring.quetion2to9;



// TO VALIDATION ERROR SHOW  USING SECIFIC DETAILS


    public class ErrorShow {

        private String message;
        private String details;

        public ErrorShow( String message, String details) {
            super();

            this.message = message;
            this.details = details;
        }


        public String getMessage() {
            return message;
        }

        public String getDetails() {
            return details;
        }
    }











