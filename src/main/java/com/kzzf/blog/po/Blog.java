package com.kzzf.blog.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// PO：persisent object，持久层对象

@Entity    // 和数据库关联
@Table(name="t_blog")  // 设置数据库中对应的表名，不设置的话默认和类名相同
public class Blog {
    @Id  // 标识为id主键
    @GeneratedValue  // 自动生成
    private Long id;

    private String title;
    private String content;
    private String firstPicture;
    private String flag;    // 标记，原创，转载等
    private Integer views;    // 浏览次数
    private boolean appreciation;  //是否开启赞赏
    private boolean shareStatement;  // 是否版权声明
    private boolean commentabled;  // 是否开启评论
    private boolean published;  // 是否发布或保存为草稿
    private boolean recommend;  // 是否推荐
    @Temporal(TemporalType.TIMESTAMP)  // // 设置日期在数据库的存储形式：日期+时间
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne()
    private Type type;

    // 括号里的参数代表新建一个blog对象时，会级联新增一个tag对象
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();
    public Blog() {
    }

    @ManyToOne()
    private User user;

    @OneToMany(mappedBy = "blog")  // One的一端代表关系被维护(数据库中没有comments字段)，需要指定关联的字段
    private List<Comment> comments = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isAppreciation() {
        return appreciation;
    }

    public void setAppreciation(boolean appreciation) {
        this.appreciation = appreciation;
    }

    public boolean isShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public boolean isCommentabled() {
        return commentabled;
    }

    public void setCommentabled(boolean commentabled) {
        this.commentabled = commentabled;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", shareStatement=" + shareStatement +
                ", commentabled=" + commentabled +
                ", published=" + published +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
