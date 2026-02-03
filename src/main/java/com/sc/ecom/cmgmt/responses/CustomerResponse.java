package com.sc.ecom.cmgmt.responses;

public class CustomerResponse {
    private Long custId;
    private String custName;
    private String custAddr;

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custAddr='" + custAddr + '\'' +
                '}';
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddr() {
        return custAddr;
    }

    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr;
    }
}
