package com.hzfh.market.controller.common;


public class JsonBaseAction<T> extends BaseAction {
	
	public enum MessageType{
		Info,Warning,Error
	}
	
	public class Message<T> {

        private MessageType type;
        private T data;
        private String description;

        public MessageType getType() {
            return type;
        }

        public void setType(MessageType type) {
            this.type = type;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }
	
	public Message message;

    public void setMessage(Message message) {
		this.message = message;
	}

	public Message getMessage() {
        return message;
    }
}
