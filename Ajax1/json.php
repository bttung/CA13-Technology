<?php
/*
 * 0～4 のidを受け取り、それに対応したデータをJSONとして返します。
 */

$data = array(
	array('name' => 'まどか', 'mail' => 'madoka@magica.qb.jp', 'tel' => '090-9999-9999'),
	array('name' => 'ほむほむ', 'mail' => 'homura@magica.qb.jp', 'tel' => '03-1111-1111'),
	array('name' => 'マミ', 'mail' => 'mami@magica.qb.jp', 'tel' => '080-7777-7777'),
	array('name' => 'さやか', 'mail' => 'sayaka@magica.qb.jp', 'tel' => '070-1234-5678'),
	array('name' => 'あんこ', 'mail' => 'kyoko@magica.qb.jp', 'tel' => '0120-500-500'),
);

$id = $_GET['id'];

header('Content-type: application/json');
echo json_encode($data[$id]);