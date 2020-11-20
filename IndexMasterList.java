public class IndexMasterList {
	
	private ArrayList<Index> indexList;
	
	public IndexMasterList() {
		this.indexList = new ArrayList<Index>();
	}
  
	public Index getIndex(int index_){
		for (int i = 0; i < indexList.size(); i++){
			if (indexList.get(i).getIndex() == index_){
				returnIndexList.get(i)
			}
		}
		System.out.println("Error - invalid index!");
		return null;
	}
  
	public void addIndex(Index index_) {
		indexList.add(index_);
	}
	
	public void removeIndex(Index index_) {
		indexList.remove(index_);
	}
}
