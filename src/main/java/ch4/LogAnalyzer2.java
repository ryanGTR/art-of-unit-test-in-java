package ch4;

class LogAnalyzer2 {
    private IWebService service;
    private IEmailService email;


    public  LogAnalyzer2(IWebService service, IEmailService email) {
        this.service = service;
        this.email = email;
    }

    public void Analyze(String fileName) {
        if (fileName.length() < 8) {
            try {
                service.LogError("Filename too short:" + fileName);
            } catch (Exception e) {
                email.sendEmail(new EmailInfo("someone@somewhere.com","can't log", e.getMessage()));
            }

        }
    }

    public IWebService getService() {
        return service;
    }

    public void setService(IWebService service) {
        this.service = service;
    }

    public IEmailService getEmail() {
        return email;
    }

    public void setEmail(IEmailService email) {
        this.email = email;
    }
}


