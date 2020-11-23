package dao;

import model.EmailConfig;

import java.util.ArrayList;
import java.util.List;

public class EmailConfigDAOImpl implements IEmailConfigDAO {
    private List<EmailConfig> emailConfigs;

    public EmailConfigDAOImpl() {
        emailConfigs = new ArrayList<>();
    }

    @Override
    public List<EmailConfig> getAll() {
        return emailConfigs;
    }

    @Override
    public boolean update(EmailConfig emailConfig) {
        for (EmailConfig config : emailConfigs) {
            if (emailConfig.getId() == config.getId()) {
                config.setLanguage(emailConfig.getLanguage());
                config.setPageSize(emailConfig.getPageSize());
                config.setSpamFilter(emailConfig.isSpamFilter());
                config.setSignature(emailConfig.getSignature());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        for (EmailConfig emailConfig : emailConfigs) {
            if (emailConfig.getId() == id) {
                emailConfigs.remove(emailConfig);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean create(EmailConfig emailConfig) {
        for (EmailConfig config : emailConfigs) {
            if (config.getLanguage().equals(emailConfig.getLanguage()) && config.getPageSize() == emailConfig.getPageSize() && config.getSignature().equals(emailConfig.getSignature()) && config.isSpamFilter() == emailConfig.isSpamFilter()) {
                return false;
            }
        }
        emailConfigs.add(emailConfig);
        return true;
    }

    @Override
    public EmailConfig getById(long id) {
        for(EmailConfig emailConfig : emailConfigs){
            if(emailConfig.getId()==id){
                return emailConfig;
            }
        }
        return null;
    }
}
