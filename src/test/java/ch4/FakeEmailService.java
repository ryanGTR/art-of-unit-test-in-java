package ch4;

 class FakeEmailService implements IEmailService {

     public EmailInfo emailInfo;


    public void sendEmail(EmailInfo emailInfo) {
      this.emailInfo = emailInfo;
    }
}
