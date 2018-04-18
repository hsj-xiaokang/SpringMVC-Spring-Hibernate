package hsj.gz.task.entity;

import hsj.gz.support.BaseEntity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * 用户的实体类
 */
@Entity
@Table(name = "sys_user")
public class SysUser extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2491111485758197830L;
	
	/**主键**/
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    /**登录账号**/
    @Column(name = "login_account" ,length = 30 , unique = true )
    private String loginAccount;

    /**登录密码**/
    @Column(name = "login_pass" ,length = 65)
    private String loginPass;

    /**昵称**/
    @Column(name = "user_name" ,length = 20)
    private String userName;

    /**头像**/
    @Column(name = "user_head" ,length = 30)
    private String userHead;

    /**手机**/
    @Column(name = "user_phone" ,length = 20)
    private String userPhone;

    /**邮箱**/
    @Column(name = "user_email" ,length = 30)
    private String userEmail;

    /**性别**/
    @Column(name = "user_sex")
    private Integer userSex;

    /**生日**/
    @Column(name = "user_birthday" ,length = 30)
    private String userBirthday;

    /**注册时间**/
    @Column(name = "register_time" ,length = 30)
    private String registerTime;
    
    /**部门编码**/
    @Column(name = "department_key" ,length = 20)
    private String departmentKey;
    
    
    /**用户角色**/
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "sys_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	@Cache(region = "all", usage = CacheConcurrencyStrategy.READ_WRITE)
	private Set<SysRole> roles = new HashSet<SysRole>();
    
    
    /**get/set**/
    

    /**主键**/
    public Long getUserId(){
        return userId;
    }
    /**主键**/
    public void setUserId(Long userId){
        this.userId= userId;
    }
    /**登录账号**/
    public String getLoginAccount(){
        return loginAccount;
    }
    /**登录账号**/
    public void setLoginAccount(String loginAccount){
        this.loginAccount= loginAccount;
    }
    /**登录密码**/
    public String getLoginPass(){
        return loginPass;
    }
    /**登录密码**/
    public void setLoginPass(String loginPass){
        this.loginPass= loginPass;
    }
    /**昵称**/
    public String getUserName(){
        return userName;
    }
    /**昵称**/
    public void setUserName(String userName){
        this.userName= userName;
    }
    /**头像**/
    public String getUserHead(){
        return userHead;
    }
    /**头像**/
    public void setUserHead(String userHead){
        this.userHead= userHead;
    }
    /**手机**/
    public String getUserPhone(){
        return userPhone;
    }
    /**手机**/
    public void setUserPhone(String userPhone){
        this.userPhone= userPhone;
    }
    /**邮箱**/
    public String getUserEmail(){
        return userEmail;
    }
    /**邮箱**/
    public void setUserEmail(String userEmail){
        this.userEmail= userEmail;
    }
    /**性别**/
    public Integer getUserSex(){
        return userSex;
    }
    /**性别**/
    public void setUserSex(Integer userSex){
        this.userSex= userSex;
    }
    /**生日**/
    public String getUserBirthday(){
        return userBirthday;
    }
    /**生日**/
    public void setUserBirthday(String userBirthday){
        this.userBirthday= userBirthday;
    }
    /**注册时间**/
    public String getRegisterTime(){
        return registerTime;
    }
    /**注册时间**/
    public void setRegisterTime(String registerTime){
        this.registerTime= registerTime;
    }
    
	public Set<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}
    
	
}
