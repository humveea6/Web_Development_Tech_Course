package com.webdevelope.summoned.task.model;

/**
 * @author LingChen
 * Created on 2020-10-06
 */
public class LoginToken {

    /**
     * tokenName
     */
    private String tokenName;

    private Long userId;

    private String userName;

    private Long loginTime;

    private LoginToken(Builder builder) {
        setTokenName(builder.tokenName);
        setUserId(builder.userId);
        setUserName(builder.userName);
        setLoginTime(builder.loginTime);
    }


    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public static final class Builder {
        private String tokenName;
        private Long userId;
        private String userName;
        private Long loginTime;

        public Builder() {
        }

        public Builder tokenName(String val) {
            tokenName = val;
            return this;
        }

        public Builder userId(Long val) {
            userId = val;
            return this;
        }

        public Builder userName(String val) {
            userName = val;
            return this;
        }

        public Builder loginTime(Long val) {
            loginTime = val;
            return this;
        }

        public LoginToken build() {
            return new LoginToken(this);
        }
    }
}