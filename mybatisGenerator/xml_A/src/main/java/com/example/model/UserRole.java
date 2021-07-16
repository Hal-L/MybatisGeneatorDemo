package com.example.model;

import java.io.Serializable;

public class UserRole implements Serializable {
    /**
     *
     * This field was generated by MyBatis com.example.Generator.
     * This field corresponds to the database column user_role.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis com.example.Generator.
     * This field corresponds to the database column user_role.role_id
     *
     * @mbg.generated
     */
    private Integer roleId;

    /**
     * This field was generated by MyBatis com.example.Generator.
     * This field corresponds to the database table user_role
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis com.example.Generator.
     * This method returns the value of the database column user_role.user_id
     *
     * @return the value of user_role.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis com.example.Generator.
     * This method sets the value of the database column user_role.user_id
     *
     * @param userId the value for user_role.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis com.example.Generator.
     * This method returns the value of the database column user_role.role_id
     *
     * @return the value of user_role.role_id
     *
     * @mbg.generated
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis com.example.Generator.
     * This method sets the value of the database column user_role.role_id
     *
     * @param roleId the value for user_role.role_id
     *
     * @mbg.generated
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis com.example.Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", roleId=").append(roleId);
        sb.append("]");
        return sb.toString();
    }
}