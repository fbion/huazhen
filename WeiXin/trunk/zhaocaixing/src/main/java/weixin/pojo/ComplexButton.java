package weixin.pojo;
/**
 * 复合类型按钮
 * @author Administrator
 *@date 2015-11-19
 */
public class ComplexButton extends Button {
	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
	
}
