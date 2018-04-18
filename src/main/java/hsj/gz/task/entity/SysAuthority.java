package hsj.gz.task.entity;

import hsj.gz.support.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 菜单表的实体类
 * @author 胡汉三
 * @dataTime 2017-01-19 17:18:52
 */
@Entity
@Table(name = "sys_authority")
@Cache(region = "all", usage = CacheConcurrencyStrategy.READ_WRITE)
public class SysAuthority extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3201889873770406753L;

	/**主键**/
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /**连接路径或方法**/
    @Column(name = "data_url" ,length = 100)
    private String dataUrl;

    /**菜单样式**/
    @Column(name = "menu_class" ,length = 50)
    private String menuClass;

    /**菜单编码**/
    @Column(name = "menu_code" ,length = 50 , unique = true )
    private String menuCode;

    /**菜单名称**/
    @Column(name = "menu_name" ,length = 50)
    private String menuName;

    /**上级菜单编码**/
    @Column(name = "parent_menucode" ,length = 50)
    private String parentMenucode;

    /**排序**/
    @Column(name = "sequence")
    private Long sequence;

    /**菜单类型(1是左导航菜单 2是按钮权限)**/
    @Column(name = "menu_type" ,length = 2)
    private String menuType;

    /**创建时间**/
    @Column(name = "create_time" ,length = 30)
    private String createTime;

    /**主键**/
    public Long getId(){
        return id;
    }
    /**主键**/
    public void setId(Long id){
        this.id= id;
    }
    /**连接路径或方法**/
    public String getDataUrl(){
        return dataUrl;
    }
    /**连接路径或方法**/
    public void setDataUrl(String dataUrl){
        this.dataUrl= dataUrl;
    }
    /**菜单样式**/
    public String getMenuClass(){
        return menuClass;
    }
    /**菜单样式**/
    public void setMenuClass(String menuClass){
        this.menuClass= menuClass;
    }
    /**菜单编码**/
    public String getMenuCode(){
        return menuCode;
    }
    /**菜单编码**/
    public void setMenuCode(String menuCode){
        this.menuCode= menuCode;
    }
    /**菜单名称**/
    public String getMenuName(){
        return menuName;
    }
    /**菜单名称**/
    public void setMenuName(String menuName){
        this.menuName= menuName;
    }
    /**上级菜单编码**/
    public String getParentMenucode(){
        return parentMenucode;
    }
    /**上级菜单编码**/
    public void setParentMenucode(String parentMenucode){
        this.parentMenucode= parentMenucode;
    }
    /**排序**/
    public Long getSequence(){
        return sequence;
    }
    /**排序**/
    public void setSequence(Long sequence){
        this.sequence= sequence;
    }
    /**菜单类型(1是左导航菜单 2是按钮权限)**/
    public String getMenuType(){
        return menuType;
    }
    /**菜单类型(1是左导航菜单 2是按钮权限)**/
    public void setMenuType(String menuType){
        this.menuType= menuType;
    }
    /**创建时间**/
    public String getCreateTime(){
        return createTime;
    }
    /**创建时间**/
    public void setCreateTime(String createTime){
        this.createTime= createTime;
    }

	
}
