/*��ü ���� ����� �ڹٿ����� ������ �繰��
Ŭ������ ���������� , DATABASE ������ ������ �繰��
Entity ��� ��ü�������� ǥ���Ѵ�.
�ᱹ ��ü�� ǥ���ϴ� ����� �ٸ� �� ������ ����
���� �ݿ��̶�� ������ ����

��ü������� Ŭ������ �ν��Ͻ��� �����س���
��Ǫ���̶�� , database �о߿���
���̺��� ���ڵ带 ������ �� �ִ� Ʋ�� ����
���� �̶� �ϳ��� ���ڵ�� �ᱹ �ϳ��� ��ü��
�����Ѵ�...
���) ���̺� �����ϴ� ��ǰ ���ڵ���� �� 5�����,�����ڴ� 
�� ������ ���ڵ带 5���� �ν��Ͻ��� ���� ������ �ȴ�!!

�Ʒ��� Ŭ������ ���� �ۼ����� �ƴ϶� , 
�Ѱ��� ���ڵ带 ��� ���� ��������뵵�θ� ����� Ŭ�����̴�.
���ø����̼� ����о߿��� �̷��� ������ Ŭ������ ������
VO, DTO ���Ѵ�
Value Object = ���� ��� ��ü
Data Transfer Object = ���� �����ϱ� ���� ��ü

������ ������ ���̺�� ��ġ���Ѿ���
*/
package book;
//������ ���� Ŭ����!! Dummy Ŭ����
//���� ������ ��� �׸���!! �迭�� ��������?
//[][][] ������ ������ �Ѵ�..  
//�迭�� �ڷ����� ���� ���� ����.. ��ü�� �ƴ϶� �Ѱ谡 �ִ�
//��ü�� ����������!! �迭�� ��ü�� ������ �ٸ� ������� ���ߵǹǷ�
//��ü�� ó���ϴ� ���� �ξ� �� �۾�����̳� ����� ����
public class SubCategory {
	//�÷���� ��������� ���̺� �ٰ��Ͽ� ��ġ ��Ű�� // �ڷ����� �տ��ش� 
	//�����ʹ� ��ȣ�Ǿ�� �Ѵ�
	private int subcategory_id;
	private int topcategory_id;
	private String category_name;
	
	//��Ʈ�� ����Ʈ ���� + 
	public int getSubcategory_id() {
		return subcategory_id;
	}
	public void setSubcategory_id(int subcategory_id) {
		this.subcategory_id = subcategory_id;
	}
	public int getTopcategory_id() {
		return topcategory_id;
	}
	public void setTopcategory_id(int topcategory_id) {
		this.topcategory_id = topcategory_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	
}
