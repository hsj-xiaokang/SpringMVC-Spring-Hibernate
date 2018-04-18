package hsj.gz.task.entity;

import hsj.gz.support.BaseEntity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



/**
 * 角色的实体类
 */
@Entity
@Table(name = "sys_role")
@Cache(region = "all", usage = CacheConcurrencyStrategy.READ_WRITE)
public class SysRole extends BaseEntity{

	// 各个字段的含义请查阅文档的数据库结构部分
	private static final long serialVersionUID = 6019103858711599150L;
	@Id
	@GeneratedValue
	@Column(name = "role_id")
	private Long roleId;
	@Column(name = "role_key", length = 40, nullable = false, unique = true)
	private String roleKey;
	@Column(name = "role_value", length = 40, nullable = false)
	private String roleValue;
	@Column(name = "create_time", length = 30)
	private String createTime;
	@Column(name = "description", length = 200)
	private String description;
	
	@ElementCollection
	@JoinTable(name = "sys_role_permission", joinColumns = { @JoinColumn(name = "role_id") })
	@Cache(region = "all", usage = CacheConcurrencyStrategy.READ_WRITE)
	private Set<String> permissions;

	@Column(name="company_id")
	private Long companyId;
	
	public SysRole() {

	}

	

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

	public String getRoleValue() {
		return roleValue;
	}

	public void setRoleValue(String roleValue) {
		this.roleValue = roleValue;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

}
