package com.bjpowernode.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * 投标
 *
 */
@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "bid")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private int bidId;

    /**
     * 投标用户 id
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Users users;

    /**
     * 投标 招标id
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenderId")
    private Tender tender;

    /**
     * 投标状态
     */
    @Column
    private State state;

    /**
     * 招标状态 - 中文描述
     */
    private String stateChina;

    /**
     * 投标 pdf
     */
    @Column(length = 1000)
    private String pdf;

    /**
     * 投标说明
     */
    @Column(length = 1000)
    private String explainContent;

    /**
     * 创建时间
     */
    @Column(length = 30)
    private String createTime;

    public Bid() {
    }

    public Bid(Users users, State state, String pdf, String explainContent, String createTime) {
        this.users = users;
        this.state = state;
        this.pdf = pdf;
        this.explainContent = explainContent;
        this.createTime = createTime;
    }

    public Bid(Users users, Tender tender, State state, String pdf, String explainContent, String createTime) {
        this.users = users;
        this.tender = tender;
        this.state = state;
        this.pdf = pdf;
        this.explainContent = explainContent;
        this.createTime = createTime;
    }

    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Tender getTender() {
        return tender;
    }

    public void setTender(Tender tender) {
        this.tender = tender;
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
         * 等待审核
         */
        WaitForAudit("等待审核"),

        /**
         * 中标
         */
        Bid("中标"),

        /**
         * 未中标
         */
        NotWinning("未中标");


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
