public class P51InversionControl {

    interface Service {
        void execute();
    }

    static class EmailService implements Service {
        @Override
        public void execute() {
            System.out.println("Sending email...");
        }
    }

    static class SmsService implements Service {
        @Override
        public void execute() {
            System.out.println("Sending SMS...");
        }
    }

    static class Notification {
        private Service service;

        public Notification(Service service) {
            this.service = service; // Dependency injection
        }

        public void notifyUser() {
            service.execute();
        }
    }

    public static void main(String[] args) {
        Service emailService = new EmailService();
        Notification notification1 = new Notification(emailService);
        notification1.notifyUser();

        Service smsService = new SmsService();
        Notification notification2 = new Notification(smsService);
        notification2.notifyUser();
    }
}
