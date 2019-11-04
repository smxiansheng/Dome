package MyHashMap;

public class MyHashMap {
	int hash;
	Node[] Entey;

	public MyHashMap() {
		Entey = new Node[16];
	}

	public void put(Integer key, int value) {
		Node N = new Node();
		N.Hash = getHash(key); // ���hash��ͻ���㷨����ȡhashֵ��
		N.Key = key;
		N.Value = value;
		N.next = null;
		Node temp = Entey[N.Hash];
		Node tempEnd = null; // ���һ���ڵ�
		// �Ƿ��ظ�
		boolean state = false;
		if (temp == null) {
			Entey[N.Hash] = N;
		} else {
			while (temp != null) {
				// ���ظ��˵����
				if (temp.Key.equals(key)) {
					temp.Value = value;
					state = true;
					break;
				} else {
					tempEnd = temp;
					temp = temp.next;
				}
			}
			if (state != true)
				tempEnd.next = N;
		}

	}

	public Object getValue(Object key) {
        int hash = getHash(key);
        Node temp = Entey[hash];
        while(temp!=null) {
        	if(temp.Key.equals(key)) {
        		return temp.Value;
        	}
        	temp = temp.next;
        }
		return null;
	}

	public String toString() {

		String str = null;
		StringBuffer strB = new StringBuffer("{");
		for (int i = 0; i < Entey.length; i++) {
			Node temp = Entey[i];
			if (temp != null) {
				strB.append("" + temp.Key + ":" + temp.Value + ",");
				temp = Entey[i].next;
				while (temp != null) {
					strB.append("" + temp.Key + ":" + temp.Value + ",");
					temp = temp.next;
				}
			}
		}
		strB.setCharAt(strB.length() - 1, '}');
		str = strB.toString();
		return str;
	}

	public int getHash(Object key) {

		return key.hashCode() & (Entey.length - 1); // ����hashֵ��λ������

	}

}
