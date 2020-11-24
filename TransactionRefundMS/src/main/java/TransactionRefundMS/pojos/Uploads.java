package TransactionRefundMS.pojos;

public class Uploads {
	
	private int updateFileId;
	private int reimbursementId;
	private byte content;
	public Uploads() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Uploads(int updateFileId, int reimbursementId, byte content) {
		super();
		this.updateFileId = updateFileId;
		this.reimbursementId = reimbursementId;
		this.content = content;
	}
	public int getUpdateFileId() {
		return updateFileId;
	}
	public void setUpdateFileId(int updateFileId) {
		this.updateFileId = updateFileId;
	}
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public byte getContent() {
		return content;
	}
	public void setContent(byte content) {
		this.content = content;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + content;
		result = prime * result + reimbursementId;
		result = prime * result + updateFileId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uploads other = (Uploads) obj;
		if (content != other.content)
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (updateFileId != other.updateFileId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Uploads [updateFileId=" + updateFileId + ", reimbursementId=" + reimbursementId + ", content=" + content
				+ "]";
	}
	
	
}

