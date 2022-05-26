package com.app.instancedownload.util;

public class Events {

    // Event used to send adapter data notify.
    public static class AdapterNotify {

        private String notify;

        public AdapterNotify(String notify) {
            this.notify = notify;
        }

        public String getNotify() {
            return notify;
        }
    }

    // Event used to send service notify.
    public static class ServiceNotify {

        private String service;

        public ServiceNotify(String service) {
            this.service = service;
        }

        public String getService() {
            return service;
        }
    }

}
