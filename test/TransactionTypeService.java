package test;

import java.util.List;

public interface TransactionTypeService {
    public int saveTransactionType(TransactionType type);
    public TransactionType getTransactionType(int typeID);
    public int deleteTransactionType(int typeID);
    public int updateTransactionType(TransactionType type);
    public List<TransactionType> getAllTransactionTypes();
}