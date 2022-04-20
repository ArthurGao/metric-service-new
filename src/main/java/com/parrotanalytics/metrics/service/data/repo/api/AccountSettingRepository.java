package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.AccountSetting;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Data repository for user settings information.
 * 
 * @author jackson
 * @since v1
 */
@Repository
public interface AccountSettingRepository extends CrudRepository<AccountSetting, Integer>
{

    @Query("SELECT u FROM AccountSetting u WHERE u.idAccount =:idAccount")
    public List<AccountSetting> loadAccountSettings(@Param("idAccount") Integer idAccount);

    @Query("SELECT u FROM AccountSetting u WHERE u.idAccount =:idAccount AND u.settingName =:settingName")
    public AccountSetting loadAccountSettingByName(@Param("idAccount") Integer idAccount, @Param("settingName") String settingName);

    @Query("SELECT u FROM AccountSetting u WHERE u.settingName =:settingName")
    public AccountSetting loadAllSettingByName(@Param("settingName") String settingName);

    @Query("SELECT u FROM AccountSetting u WHERE u.idAccount =:idAccount AND u.settingType = :settingType")
    public List<AccountSetting> loadAccountSettingsByType(@Param("idAccount") Integer idAccount,
            @Param("settingType") String settingType);

    @Query("SELECT u FROM AccountSetting u WHERE u.settingType IN :settingTypes order by u.lastUsedOn desc")
    public List<AccountSetting> loadAllSettingsByTypes(@Param("settingTypes") List<String> settingTypes);

    @Query("SELECT u FROM AccountSetting u WHERE u.idAccount =:idAccount AND u.settingType IN :settingTypes")
    public List<AccountSetting> loadAccountSettingsByTypes(@Param("idAccount") Integer idAccount,
            @Param("settingTypes") List<String> settingType);

}
