/*
FileInputStream ���� �����ڰ� ���ϴ� ������
��Ʈ���� ������ �� ������ , Ű����� ���� ǥ�� �Է� �ϵ������ ��쿣
�ڹٰ� ��Ʈ���� �������� ���ϰ� �ش� OS�� �����ϹǷ�, �ڹ� �����ڴ�
OS�� ���� ǥ���Է� ��Ʈ���� ���;� �Ѵ�..

�ڹ��� Ŭ���� �� System Ŭ������ static ������� ��
�� has a ����� ������ InputStream ��
in ��ü�� �ٷ� ǥ���Է� ��Ʈ���� �޾Ƴ��� Ŭ�����̴�
���� ���ÿ� �׳� System.int;

����Ʈ��� ��Ʈ���� �ѱ��� �����ϱ� �̶� �ʿ��Ѱ� ���ڱ�� ��Ʈ��!!

���ڱ�� ��Ʈ�� Ŭ������ �̸� ��Ģ
�Է� : ~~Reader 
��� : ~~Writer 

���ڴ� ����Ʈ ����̴�
����Ʈ�� ���� ���� < ���ڱ���� ���� ���� �����ɷ� ����..

*/


package io;
import java.io.InputStream;

import java.io.IOException;
import java.io.InputStreamReader;

class KeyBoardApp{
	public static void main(String[] args){
		InputStream is=System.in;

		//���ڱ�� ��Ʈ���� �ܵ����� �����ϴ� ���� �ƴ϶�,
		//�̹� ����Ʈ ��� ��Ʈ���� ������ �Ѵ�..
		//���� ������ �������� �μ��� ����Ʈ ��� ��Ʈ���� �ִ´�..
		InputStreamReader reader=null;
		//���ڿ� ����� �Է� ��Ʈ��
		reader=new InputStreamReader(is);

		int data;
		try{
			while(true){
				data=reader.read();
				//data=is.read(); //1byte �о���� //�ѱ��� ������, ������ �ȱ����Ե�
				//����Ʈ��� ��Ʈ���� �ѱ��� �����ϱ� �̶� �ʿ��Ѱ� ���ڱ�� ��Ʈ��!!
				System.out.println((char)data);
			//system�� ������ out �̶�� static ������� 
			//a��ġ�� enter ������ a,\n,\r ���� 3byte �� ���;��ϴµ�..
			//readt�� 1byte �� �����ϱ�
			//�� 3�� ��µǾ�� ���´� --> while ������ ������..
			//���������� �ٲٸ� a�� �״�� a ������,  \n �� ��ɻ����θ� ���ͼ�
			//���� ��������(�ٹٲ�), \r Ŀ�������οű�� --> Ư�����ڴ� �������� ���°� �ƴ϶� ��ɴ���̶� ��µ����� ��ɸ� �����!! 
			}
		}catch(IOException e){
			
		}
	}

}
