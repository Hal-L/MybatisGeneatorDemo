package com.hengzhou.mp.model;// package com.ali.TJobEx.model;
//
// import com.fasterxml.jackson.annotation.JsonInclude;
//
//
// @JsonInclude(JsonInclude.Include.NON_NULL)
// public class Response20Model {
//
//     //返回结果状态码，格式见下
//     private String status;
//     //请求到达的系统时间，精确 到毫秒用于日志记录问题排 查等
//     private String requestId;
//     //接口调用出错时返回的错误 码(内部定义)，调用方可根 据错误码来定位错误原因。
//     private String errorCode = ErrorCode.SUCCESS.getErrorCode();
//     //接口调用出错时返回的错误 信息说明，成功则该字段为 "success"。
//     private String errorMsg = ErrorCode.SUCCESS.getErrorMsg();
//     //返回的结果数据，请求接口 不同， 返回结果格式不同，请查看 对应接口详情。
//     private Object data;
//     //与 1.5.2 查询类请求 offset、 size 参数对应，表示应查询到的所有结果总数，适用于 所有查询列表的接口。
//     private Integer totalCnt;
//
//     private Response20Model() {
//         /**
//          * not allow to new
//          */
//     }
//
//     public static Response20Model instance() {
//         return new Response20Model();
//     }
//
//     public Response20Model setData(Object data) {
//         this.data = data;
//         return this;
//     }
//
//     public Response20Model setErrorCode(ErrorCode errorCode) {
//         this.errorCode = errorCode.getErrorCode();
//         this.errorMsg = errorCode.getErrorMsg();
//         return this;
//     }
//
//     public Response20Model setStatus(Code code) {
//         this.status = code.getCode();
//         return this;
//     }
//
//     public Object getData() {
//         return data;
//     }
//
//     public String getStatus() {
//         return status;
//     }
//
//     public Integer getTotalCnt() {
//         return totalCnt;
//     }
//
//     public Response20Model setTotalCnt(Integer totalCnt) {
//         this.totalCnt = totalCnt;
//         return this;
//     }
//
//     public String getRequestId() {
//         return requestId;
//     }
//
//     public Response20Model setRequestId(String requestId) {
//         this.requestId = requestId;
//         return this;
//     }
//
//     public String getErrorCode() {
//         return errorCode;
//     }
//
//     public String getErrorMsg() {
//         return errorMsg;
//     }
//
//     @Override
//     public String toString() {
//         return "ResponseModel{" +
//                 "status='" + status + '\'' +
//                 ", resultCode='" + errorCode + '\'' +
//                 ", resultMsg='" + errorMsg + '\'' +
//                 ", data=" + data +
//                 ", totalCnt=" + totalCnt +
//                 ", requestId=" + requestId +
//                 '}';
//     }
// }
