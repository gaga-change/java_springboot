package com.yanjd.java.task;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "my_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键由数据库自动生成
    private int id;

    // 有限级
    public static int LEVEL_0 = 0;
    public static int LEVEL_1 = 1;
    public static int LEVEL_2 = 2;
    public static int LEVEL_3 = 3;

    private String content; // 内容
    private int level; // 级别： 1，2，3
    private Boolean close; // 是否关闭
    private Date createTime; // 创建时间
    private Date modifyTime; // 修改时间
    private Boolean remove; // 是否移除

    public Task() {
        this.close = false;
        this.createTime = new Date();
        this.modifyTime = new Date();
        this.remove = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        level = Math.max(0, level);
        level = Math.min(3, level);
        this.level = level;
    }

    public Boolean getClose() {
        return close;
    }

    public void setClose(Boolean close) {
        this.close = close;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Boolean getRemove() {
        return remove;
    }

    public void setRemove(Boolean remove) {
        this.remove = remove;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", level=" + level +
                ", close=" + close +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", remove=" + remove +
                '}';
    }
}
