package dao;

import model.EmailConfig;

import java.util.List;

public interface IEmailConfigDAO {
    List<EmailConfig> getAll();

    boolean update(EmailConfig emailConfig);

    boolean delete(long id);

    boolean create(EmailConfig emailConfig);

    EmailConfig getById(long id);
}
