/**
 * 
 */
/**
 * @author song
 *
 */
package s111;
public class song {
	private String name ;
	private int age ;
	private String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public static void main(String[] args) {
		song s = new song();
		s.setAge(20);
		System.out.println(s.getAge());
	}
}