
enum MyEnumClass {
	
	BIG(1),
	SMALL(2),
	TINY(3);
	
	private final int m_size;
	
	MyEnumClass(int size)
	{
		m_size = size;
	}
	
	public void printSize()
	{
		System.out.println(m_size);
	}
}
