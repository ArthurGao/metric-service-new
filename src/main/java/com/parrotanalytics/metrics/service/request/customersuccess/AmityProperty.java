package com.parrotanalytics.metrics.service.request.customersuccess;

public class AmityProperty
{

    private String op;
    private String path;
    private Object value;

    public AmityProperty(String op, String path, Object value)
    {
        super();
        this.op = op;
        this.path = path;
        this.value = value;
    }

    public String getOp()
    {
        return op;
    }

    public void setOp(String op)
    {
        this.op = op;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

}
