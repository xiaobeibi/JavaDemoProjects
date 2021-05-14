package com.bjpowernode.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * 招标
 *
 */
@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "tender")
public class Tender {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private int tenderId;

    @Column(length = 30)
    private String tenderName;

    /**
     * 中标服务商用户 id
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Users users;

    /**
     * 招标状态
     */
    @Column
    private State state;

    /**
     * 招标状态 - 中文描述
     */
    private String stateChina;

    /**
     * 招标 pdf
     */
    @Column(length = 1000)
    private String pdf;

    /**
     * 招标说明
     */
    @Column(length = 1000)
    private String explainContent;

    /**
     * 创建时间
     */
    @Column(length = 30)
    private String createTime;

    public Tender() {
    }

    public Tender(String tenderName, State state, String pdf, String explainContent, String createTime) {
        this.tenderName = tenderName;
        this.state = state;
        this.pdf = pdf;
        this.explainContent = explainContent;
        this.createTime = createTime;
    }

    public int getTenderId() {
        return tenderId;
    }

    public void setTenderId(int tenderId) {
        this.tenderId = tenderId;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getStateChina() {
        return stateChina;
    }

    public void setStateChina(String stateChina) {
        this.stateChina = stateChina;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getExplainContent() {
        return explainContent;
    }

    public void setExplainContent(String explainContent) {
        this.explainContent = explainContent;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public enum State {

        /**
         * 正在公示
         */
        BeingPublicized("正在公示"),

        /**
         * 即将开标
         */
        UpcomingOpening("即将开标"),

        /**
         * 招标中
         */
        Bidding("招标中"),

        /**
         * 招标结束
         */
        TenderEnd("招标结束");


        private String describe;

        State(String describe) {
            this.describe = describe;
        }

        public static State forName(String name) {
            for (State state : State.values()) {
                if (state.name().equals(name)) {
                    return state;
                }
            }
            return null;
        }

        public String getDescribe() {
            return describe;
        }
    }
}
