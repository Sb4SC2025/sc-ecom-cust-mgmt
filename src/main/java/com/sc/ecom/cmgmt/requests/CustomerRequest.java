package com.sc.ecom.cmgmt.requests;

import com.sc.ecom.cmgmt.dao.entities.Address;

public class CustomerRequest {
    private Long custId;
    private String custName;
    private Long custAddr;

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

    public Long getCustAddr() {
        return custAddr;
    }

    public void setCustAddr(Long custAddr) {
        this.custAddr = custAddr;
    }
}
