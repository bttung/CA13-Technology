package jp.co.ca.dao;

import java.util.List;

import jp.co.ca.entity.Stock;


/**
 * ユーザ管理(CRUD)を提供するDAOインターフェースです。
 *
 * @author t.kozuma
 *
 */
public interface StockDao {

	/**
	 * 指定されたidをもつ在庫を削除します。
	 *
	 * @param id 削除するid
	 * @return 削除した件数
	 */
	public int delete(int id);

	/**
	 * 在庫品を全件取得します。
	 * 1件もデータが存在しない場合はサイズ0のListを返します。
	 *
	 * @return 全件データ
	 */
	public List<Stock> findAll();

	/**
	 * idを元に一致する在庫品を返します。
	 * idに一致する在庫品が存在しなかった場合nullを返します。
	 *
	 * @param id ユーザのid
	 * @return idが一致した在庫品 または null
	 */
	public Stock findById(int id);

	/**
	 * 指定された在庫品を登録します。
	 * また登録成功時に自動で設定されたidをセットします。
	 *
	 * @param stock 登録するStock
	 * @return 登録した件数
	 * @throws NullPointerException stockがnullの場合
	 */
	public int insert(Stock stock);

	/**
	 * 指定された在庫品をidに基づいて更新します。
	 *
	 * @param stock 更新する在庫品
	 * @return 更新した件数
	 * @throws NullPointerException stockがnullの場合
	 */
	public int update(Stock stock);

}
