package com.scuthnweb.action.notemodule;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.impl.NoteModuleImpl;
import com.scuthnweb.service.interf.NoteModule;

public class ModifyNoteAction extends ActionSupport{
     
	private  NoteModule  noteModule;
    private  int note_id,  note_type, note_publisher;
    private  String note_name, note_content;
	
    
    public  String execute(){
    	
    	this.noteModule = new NoteModuleImpl();
    
    	//调用业务逻辑层组件
        if( this.noteModule.modifyNote(note_id, note_name, note_type, note_content, note_publisher))
        	   return SUCCESS;
        else   return ERROR;
    }
    
d
项目问题7
    public void validate(){
        
    	//校验发布的信息名称
    	String regexNoteName = "^[\\u4E00-\\u9FA5\\w]{2,20}$";
        if( !Pattern.matches(regexNoteName, this.note_name) )
             this.addFieldError("note_name","发布的信息名称为由简体中文，数字或英文字母组成2~20个字符长度的字符串！");
d
-项目问题7 ;       
        //校验发布的信息内容
        String regexNoteContent = "^[\\u4E00-\\u9FA5\\w]{3,8000}$";
        if( !Pattern.matches(regexNoteContent, this.note_content))
        	this.addFieldError("note_content","发布的信息内容字数不应超过8000（包含标点等其他符号）！");
}
    
 
	
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	
	
	public int getNote_type() {
		return note_type;
	}
	public void setNote_type(int note_type) {
		this.note_type = note_type;
	}
	
	
	public int getNote_publisher() {
		return note_publisher;
	}
	public void setNote_publisher(int note_publisher) {
		this.note_publisher = note_publisher;
	}
	
	
	public String getNote_name() {
		return note_name;
	}
	public void setNote_name(String note_name) {
		this.note_name = note_name;
	}
	
	
	public String getNote_content() {
		return note_content;
	}
	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}
       
}