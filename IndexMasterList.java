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
		System.out.println("Error - invalid index!"); /*need exception handling here I think*/
	}
  
	public void addIndex(Index new) {
		indexList.add(new);
	}
	
	public void removeIndex(Index index_) {
		indexList.remove(index_);
	}
}
