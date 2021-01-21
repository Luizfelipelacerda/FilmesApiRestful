package com.luizfelipe.locadora.exception;

public class PretoException extends Exception{
    public String msg;
    public PretoException(String msg){
        super(msg);
        this.msg = msg;
    }

}
