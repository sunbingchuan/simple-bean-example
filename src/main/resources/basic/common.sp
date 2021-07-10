builder
	name:life
	class:com.chuan.simple.bean.example.basic.bean.common.Life
builder
	name:experience
	class:com.chuan.simple.bean.example.basic.bean.common.Experience
builder
	name:mySuccess
	class:com.chuan.simple.bean.example.basic.bean.common.Success
	build-parameter
		val:love
	build-parameter
		val:creativity
builder
	name:yourSuccess
	class:com.chuan.simple.bean.example.basic.bean.common.Success
	field
		name:conditionX
		val:study
	field
		name:conditionY
		val:work
builder
	name:history
	class:com.chuan.simple.bean.example.basic.bean.common.History
	field
		name:dynastys
		map
			pair
				key
					val:Tang
				value
					val:唐朝
			pair
				key
					val:Song
				value
					val:宋
			pair
				key
					val:Yuan
				value
					val:元
	field
		name:storys
		array
			ele
				val:玄武门之变
			ele
				val:莫须有
			ele
				val:南坡之变
	field
		name:celebrity
		list
			ele
				val:李世民
			ele
				val:岳飞
			ele
				val:成吉思汗
import
	resource:./from-import.sp

builder
	name:aliasTest
	class:com.chuan.simple.bean.example.basic.bean.common.Displayer
	alias:alias1 alias2 alias3
	build-parameter
		val:Test alias.
	
alias
	name:aliasTest
	alias:alias4,alias5
alias
	name:alias5
	alias:alias6,alias7
	
builder
	name:miracleCreater
	class:com.chuan.simple.bean.example.basic.bean.common.MiracleCreator
builder
	name:literaryMiracle
	class:com.chuan.simple.bean.example.basic.bean.common.Miracle
	method-name:create
	owner-name:miracleCreater
	build-parameter
		val:literary
builder
	name:scientificMiracle
	class:com.chuan.simple.bean.example.basic.bean.common.Miracle
	method-name:create
	owner-class-name:com.chuan.simple.bean.example.basic.bean.common.MiracleCreator
	build-parameter
		val:scientific
		
	
