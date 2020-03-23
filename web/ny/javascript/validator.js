/*
*????:????????????????
*?????windy
*/

//???????????????????????????????????
//function validater(frmObj)
var context="/pcoa"
function validater(frmObj, strAlert){
	
	var msgTmp="";
	var msg="";
	
	
	if (strAlert != "" && strAlert != null){ 
		msg = "--" + strAlert + "\n";	
	}
	

	var arrType;
	var arrMsg="";
	var el;
	for(var i=0;i<frmObj.elements.length;i++){
		el=frmObj.elements[i];
		if(el.ValidateType!=null){
			arrType=el.ValidateType.split(",");
			if(el.Msg==null) el.Msg="";
			arrMsg=el.Msg.split(";");
			if(arrType.length==arrMsg.length){
				for(var j=0;j<arrType.length;j++){
					if(!ValidateEl(el,arrType[j])){
						msg+="--"+arrMsg[j]+"\n";
					}
				}
			}
		}
	}
   if(frmObj.elements["vo.password"]!=null){
	 if(frmObj.elements["vo.password"][0]!=null&&frmObj.elements["vo.password"][1]!=null){
		if(frmObj.elements["vo.password"][0].value!=frmObj.elements["vo.password"][1].value){
	      msg+="--???????????????,??????????"
          frmObj.elements["vo.password"][0].value="";
	      frmObj.elements["vo.password"][1].value="";
	    }
      }
	
	if(frmObj.elements["vo.password"][0]!=null&&frmObj.elements["vo.password"][1]==null){
    	   msg+="--???????????????,??????????"
          frmObj.elements["vo.password"][0].value="";
	      frmObj.elements["vo.password"][1].value="";

	}
	if(frmObj.elements["vo.password"][0]==null&&frmObj.elements["vo.password"][1]!=null){
    	   msg+="--???????????????,??????????"
          frmObj.elements["vo.password"][0].value="";
	      frmObj.elements["vo.password"][1].value="";

	}


   }
  

	if(msg!=""){
		alert(msg);
		return false;
	}
	return true;
}




// ? String ????????? trim ????
String.prototype.trim = function()
{
    // ?????????????????????????????
    return this.replace( /(^\s*)|(\s*$)/g, "" );
}

// ??????????????? s ????????? re
function checkExp( re, s )
{
	return re.test( s );
}

// ?????? ???????
function isAlphaNumeric( strValue )
{
	// ????? A-Z a-z 0-9 ??????????? ???????
	return checkExp( /^\w*$/gi, strValue );
}

// ----- Added by linhs 2003-10-30 [begin] -----
// ?????? ???
function isAlpha( strValue )
{
	// ????? A-Z a-z ??????????? ???????
	return checkExp(/[A-Za-z_]/i, strValue );
}
// ----- Added by linhs 2003-10-30 [ end ] -----

// ?????? ????
function isDate( strValue )
{
	// ???????????? 2001-10-1/2001-1-10 ???????
	if( isEmpty( strValue ) ) return true;

	if( !checkExp( /^\d{4}-[01]?\d-[0-3]?\d$/g, strValue ) ) return false;
	// ???? /^\d{4}-[1-12]-[1-31]\d$/

	var arr = strValue.split( "-" );
	var year = arr[0];
	var month = arr[1];
	var day = arr[2];

	// 1 <= ??? <= 12??1 <= ???? <= 31
	if( !( ( 1<= month ) && ( 12 >= month ) && ( 31 >= day ) && ( 1 <= day ) ) )
		return false;

	// ??????
	if( !( ( year % 4 ) == 0 ) && ( month == 2) && ( day == 29 ) )
		return false;

	// 7??????????????????30??
	if( ( month <= 7 ) && ( ( month % 2 ) == 0 ) && ( day >= 31 ) )
		return false;

	// 8?????????????????30??
	if( ( month >= 8) && ( ( month % 2 ) == 1) && ( day >= 31 ) )
		return false;

	// 2?????29??
	if( ( month == 2) && ( day >=30 ) )
		return false;

	return true;
}

// ?????? ??? add by ???? (2003-7-29)
function isTimeOnly( strValue )
{
	// ???????????? 2001-10-1/2001-1-10 ???????
	if( isEmpty( strValue ) ) return true;

	if( !checkExp( /^[0-2]?\d:[0-5]?\d$/g, strValue ) ) return false;
	//????if( !checkExp( /^(0[0-9]|1[0-9]|2[0-3]):((0[0-9])|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9])$/g, strValue ) ) return false;
	// ???? /^\d{4}-[1-12]-[1-31]\d$/

	var arr=strValue.split(":");
	var hour=arr[0];
	var minute=arr[1];


	if(!((0<=hour)&&( 23 >= hour )&&( 59 >= minute ) && (0 <= minute )))
		return false;



	return true;
}

// ??????????? ??????????? add by ???? (2003-7-29)
function isTime( strValue )
{
	// ???????????? 2001-10-1/2001-1-10 ???????
	
	if( isEmpty( strValue ) ) return true;

	if( !checkExp( /^\d{4}-[01]?\d-[0-3]?\d+\s+[0-2]?\d:[0-6]?\d:[0-6]?\d$/g, strValue ) ) return false;
	// ???? /^\d{4}-[1-12]-[1-31]\d$/

	var arr=strValue.split(" ");
	var arr1 = arr[0].split( "-" );
	var year = arr1[0];
	var month = arr1[1];
	var day = arr1[2];
	var arr2=arr[1].split(":");
	var hour=arr2[0];
	var minute=arr2[1];
	var second=arr2[2];

	// 1 <= ??? <= 12??1 <= ???? <= 31
	if( !( ( 1<= month ) && ( 12 >= month ) && ( 31 >= day ) && ( 1 <= day ) ) )
		return false;

	// ??????
	if( !( ( year % 4 ) == 0 ) && ( month == 2) && ( day == 29 ) )
		return false;

	// 7??????????????????30??
	if( ( month <= 7 ) && ( ( month % 2 ) == 0 ) && ( day >= 31 ) )
		return false;

	// 8?????????????????30??
	if( ( month >= 8) && ( ( month % 2 ) == 1) && ( day >= 31 ) )
		return false;

	// 2?????29??
	if( ( month == 2) && ( day >=30 ) )
		return false;

	if(!((0<=hour)&&( 23 >= hour )&& ( 59 >= minute ) && ( 0 <= minute )&& ( 59 >= second ) && ( 0 <= second )))
		return false;


	return true;
}

// ??????????? ??????????? add by ???? (2003-08-12)
function isTime1( strValue )
{
	// ???????????? 2001-10-1/2001-1-10 ???????
	if( isEmpty( strValue ) ) return true;

	if( !checkExp( /^\d{4}-[01]?\d-[0-3]?\d+\s+[0-2]?\d:[0-6]?\d:[0-6]?\d$/g, strValue ) ) return false;
	// ???? /^\d{4}-[1-12]-[1-31]\d$/

	var arr=strValue.split(" ");
	var arr1 = arr[0].split( "-" );
	var year = arr1[0];
	var month = arr1[1];
	var day = arr1[2];
	var arr2=arr[1].split(":");
	var hour=arr2[0];
	var minute=arr2[1];
	var second=arr2[2];

	// 1 <= ??? <= 12??1 <= ???? <= 31
	if( !( ( 1<= month ) && ( 12 >= month ) && ( 31 >= day ) && ( 1 <= day ) ) )
		return false;

	// ??????
	if( !( ( year % 4 ) == 0 ) && ( month == 2) && ( day == 29 ) )
		return false;

	// 7??????????????????30??
	if( ( month <= 7 ) && ( ( month % 2 ) == 0 ) && ( day >= 31 ) )
		return false;

	// 8?????????????????30??
	if( ( month >= 8) && ( ( month % 2 ) == 1) && ( day >= 31 ) )
		return false;

	// 2?????29??
	if( ( month == 2) && ( day >=30 ) )
		return false;

	if(!((0<=hour)&&( 23 >= hour )&& ( 59 >= minute ) && ( 0 <= minute )&& ( 59 >= second ) && ( 0 <= second )))
		return false;


	return true;
}


// ?????? Email
function isEmail( strValue )
{
	// Email ?????? x@a.b.c.d ???? ???????
	if( isEmpty( strValue ) ) return true;

	//return checkExp( /^\w+@(\w+\.)+\w+$/gi, strValue );	//2001.12.24??????? ??? jxj-xxx@yysoft.com????????
	//Modify By Tianjincat 2001.12.24
	var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
	return checkExp( pattern, strValue );

}

// ?????? ???
function isEmpty( strValue )
{
	if( strValue == "" )
		return true;
	else
		return false;
}

// ?????? ????
function isNumeric( strValue )
{
	// ????????? 0123456789 ???????

	//return checkExp( /^\d*$/g, strValue );
	return !isNaN(strValue);

	//return  checkExp(/\ \^(-|\+)?\d+(\.\d+)?$/g, strValue );
}

// ?????? ????
function isInt( strValue )
{
	// ????????? 0123456789 ???????

	return checkExp( /^\d*$/g, strValue );

	//return  checkExp(/\ \^(-|\+)?\d+(\.\d+)?$/g, strValue );
}


// ?????? ????
function isMoney( strValue )
{
	// ????????? -12,345,678.9 ???? ???????
	if( isEmpty( strValue ) ) return true;

	return checkExp( /^[+-]?\d+(,\d{3})*(\.\d+)?$/g, strValue );
}

function isMoney1( strValue )
{
	// ????????? 1111.43???? ???????
	if( isEmpty( strValue ) ) return true;

	return checkExp( /^[+-]?\d{1,6}\.\d{2}$/g, strValue );
}

//?????????(decimal)
function isDecimal( strValue ){

	if( isEmpty( strValue ) ) return true;
	if (isNumeric(strValue)==false)
		return false;
	var iPos =0,strInt, strScale;
	iPos = strValue.indexOf(".");
	if (iPos < 0){
		strInt = strValue;
		strScale ="";
	} else {
		strInt = strValue.substring(0,iPos);
		strScale = strValue.substring(iPos+1, strValue.length)
	}
	if (strInt.length>14){
		return false;
	}
	if (strScale.length>4){
		return false;
	}
	return true;


}
// ?????? ???
function isPhone( strValue )
{
	// ??????	(0755)4477377-3301/(86755)6645798-665
	// Call ??	95952-351
	// ???		130/131/135/136/137/138/13912345678
	// ???????
	if( isEmpty( strValue ) ) return true;

	return checkExp( /(^\(\d{3,5}\)\d{6,8}(-\d{2,8})?$)|(^\d+-\d+$)|(^(130|131|132|133|134|135|136|137|138|139)\d{8}$)/g, strValue );
}

// ?????? ????????
function isPostalCode( strValue )
{
	// ?????????????6??????
	return checkExp( /(^$)|(^\d{6}$)/gi, strValue )
}


// ?????? URL
function isURL( strValue )
{
	// http://www.yysoft.com/ssj/default.asp?Type=1&ArticleID=789
	if( isEmpty( strValue ) ) return true;

	var pattern = /^(http|https|ftp):\/\/(\w+\.)+[a-z]{2,3}(\/\w+)*(\/\w+\.\w+)*(\?\w+=\w*(&\w+=\w*)*)*/gi;
	// var pattern = /^(http|https|ftp):(\/\/|\\\\)(\w+\.)+(net|com|cn|org|cc|tv|[0-9]{1,3})((\/|\\)[~]?(\w+(\.|\,)?\w\/)*([?]\w+[=])*\w+(\&\w+[=]\w+)*)*$/gi;
	// var pattern = ((http|https|ftp):(\/\/|\\\\)((\w)+[.]){1,}(net|com|cn|org|cc|tv|[0-9]{1,3})(((\/[\~]*|\\[\~]*)(\w)+)|[.](\w)+)*(((([?](\w)+){1}[=]*))*((\w)+){1}([\&](\w)+[\=](\w)+)*)*)/gi;

	return checkExp( pattern, strValue );

}


//-- Added by linhs 2004-3-12 [begin] --
/*
*????'<' ??'>' ??'&'?? '"'?? '\''??
*/
function exceptLawlessChar(strValue) {
	if (strValue.indexOf('<') >= 0 || strValue.indexOf('>') >= 0
		|| strValue.indexOf('&') >= 0 || strValue.indexOf('"') >= 0
		|| strValue.indexOf('\'') >= 0){
		return false;
	} else {
		return true;
	}
}
//-- Added by linhs 2004-3-12 [ end ] --


// ??????????
//
//	strValue	?????
//	strParam	?????????????L<10, L=5, L>117
//
function checkLength( strValue, strParam )
{
	if( isEmpty( strValue ) )	return true;

	// ?????????L<10, L=5, L>117
	if( strParam.charAt( 0 ) != 'L' )	return false;

	var l = strValue.length;
	var ml = parseInt( strParam.substr( 2 ) );

	switch( strParam.charAt( 1 ) )
	{
		case '<' :
			if( l >= ml )
				return false;
			break;

		case '=' :
			if( l != ml )
				return false;
			break;

		case '>' :
			if( l <= ml )
				return false;
			break;

		default :
			return false
	}

	return true;
}


// ?????????????????????????????????**???????
//
//	???????
//		strName		???????
//		strDescription	???????
//		strLength	???????
//
function ValidateMaxLength( strName, strDescription, strLength) {
	var strMsg = "";
	var strValue = document.all( strName ).value.trim();
	var strMaxLength = "L<" + strLength;
	if( !checkLength( strValue, strMaxLength ))
	strMsg = '"' + strDescription + '" ????????'+ strLength + '?????\n';
	return strMsg;
}

// ??????????????????????????????????**???????
//
//	???????
//		strName		???????
//		strDescription	???????
//		strLength	???????
//
function ValidateMinLength( strName, strDescription, strLength) {
	var strMsg = "";
	var strValue = document.all( strName ).value.trim();
	var strMaxLength = "L>" + strLength;
	if( !checkLength( strValue, strMaxLength ))
	strMsg = '"' + strDescription + '" ???????'+ strLength + '?????\n';
	return strMsg;
}

// ??????????????????????????????**???????
//
//	???????
//		strName		???????
//		strDescription	???????
//		strLength	???????
//
function ValidateEquLength( strName, strDescription, strLength) {
	var strMsg = "";
	var strValue = document.all( strName ).value.trim();
	var strMaxLength = "L=" + strLength;
	if( !checkLength( strValue, strMaxLength ))
	strMsg = '"' + strDescription + '" ???????'+ strLength + '?????\n';
	return strMsg;
}

//
//	???????
//		obj		???????
//		strType	???????
//
function ValidateEl( obj, strType)
{
	var strMsg ="";
	var result=true;
	var strValue = obj.value.trim();

	switch( strType.toLowerCase() )
	{
		case "alphanumeric" :	// ???????
			result=isAlphaNumeric( strValue ) ;
			break;

		case "date" :	// ????
			result=isDate( strValue );
			if (result) {obj.value = formatDate(strValue)}
			break;

		case "time":    //????????
			result=isTime(strValue);
			if (result) {obj.value = formatTime1(strValue)}
			break;

		case "time1":    //????????
			result = isTime1(strValue);
			if (result) {obj.value = formatTime1(strValue)}
			break;

		case "timeonly":  //???
			result=	isTimeOnly(strValue);
			break;

		case "email" :	// ???????
			result=isEmail(strValue);
			break;

		case "notempty" :	// ??????
		
			result=!isEmpty( strValue );
			break;
		case "numeric" :	//????
			result=isNumeric( strValue );

			break;
		case "int" :	//????
			result=isInt( strValue );

			break;
		case "money" :	//????
			result=isMoney( strValue );
			break;
			
		case "money1" :	//????
			result=isMoney1( strValue );
			break;
		case "decimal" :	//????
			result=isDecimal( strValue );
			break;	
		case "phone" :	// ???
			result=isPhone( strValue );
			break;

		case "postalcode" :	// ????????
			result=isPostalCode( strValue );
			break;

		case "url" :	// URL
			result=isURL( strValue );
			break;

		case "exceptlawlesschar" :
			result=exceptLawlessChar(strValue);
			break;
	}

	return result;
}

// ----- Added by linhs 2003-10-30 [begin] -----
// ???????????????? true
function isTheFunctionKeys(code) {
  if (code==46 || code==37 || code==39 || code==8 || code==9) {
    return true;
  } else {
    return false;
  }
}
// ----- Added by linhs 2003-10-30 [ end ] -----

/**********************
*??????????????????????
***********************/
function setBoxInputType(){
	
	var flag=this.onlytype;

	var txt="";
	var code=event.keyCode;
	txt=this.value;

	if(flag.toLowerCase()=="url"){
	  if (!isURL(strChart))
		  return false;
    }
	if (flag.toLowerCase()=="strj")
	{   if(code==191)
			return false;
		else
			return true;
	}
	if(event.shiftKey&&flag.toLowerCase()!="email") {
	  return false;
	}

	if(flag.toLowerCase()=="int"){
	  if(code==190) {
	    return false;
	  }
	  // modified by linhs 2003-10-31
	  // if((code<96 || code>105) && (code<48 || code>57) && code!=190 &&  code!=46 && code!=37 &&  code!=39 &&  code!=8 && code!=9){
	  if ((code<96 || code>105) && (code<48 || code>57) && !isTheFunctionKeys(code)) {
		return false;
	  }
	}
	
	if(flag.toLowerCase()=="float"){
		//alert(" code=" + code);
		if(txt=="" && code==190) 
		  return false;
		if ((code<96 || code>105) && (code<48 || code>57) && code!=190 && code!=110 && !isTheFunctionKeys(code)) {
			//alert(txt + " code1=" + code);
			return false;
		}
		if(txt.indexOf(".")!=-1 && (code==190 || code==110)) {
		//alert(txt + " code2=" + code);
		  return false;
		}
	}
	if(flag.toLowerCase()=="mobiles"){
		//alert(code);
		var len =txt.length;
		
		if (code ==188)
		{
			if (txt=="")
			{
				return false;
			} else if (txt.substring(len-1,len)==","){
				return false;
			} else {
				return true;
			}
		}
		
		if ((code<96 || code>105) && (code<48 || code>57) && !isTheFunctionKeys(code)) {
			return false;
		}
		
	}
	// ----- Added by linhs 2003-10-30 [begin] -----
	if(flag.toLowerCase()=="alpha"){
		var strChart=String.fromCharCode(code);
		if ((!isAlpha(strChart) || code==190 || (code>=96 && code<=111)) && !isTheFunctionKeys(code))
		  return false;
	}
	if(flag.toLowerCase()=="money1" || flag.toLowerCase()=="decimal"){
		if(txt=="" && code==190) 
		  return false;		
		if(txt.indexOf(".")!=-1 && (code==190 || code==110)) 
		  return false;
		if((code<96 || code>105) && (code<48 || code>57) && code!=190 && code!=110 &&  code!=46 && code!=37 &&  code!=39 &&  code!=8 && code!=9){
			return false;	
		}
	}
	// ----- Added by linhs 2003-10-30 [ end ] -----
	
	return true;

}

function checkPasteData(){
	var pasteData=window.clipboardData.getData('Text');
	switch(this.onlytype.toLowerCase()){

		case "int":
			if(!isInt(pasteData)){
				alert("?????????????????????????????????????.");
				event.returnValue=false;
			}
			break;
		case "float":
			if(!isNumeric(pasteData)){
				alert("????????????????????????????????????.");
				event.returnValue=false;
			}
			break;
        // ----- Added by linhs 2003-11-5 [begin] -----        
		case "alpha":
			if (!isAlpha(pasteData) && (this.value.length!=0)) {
                alert("?????????????????????????????????????????????.");
				event.returnValue=false;
			}
		// ----- Added by linhs 2003-11-5 [begin] -----
	}

}

function checkInputValue(){
	var value=this.value;
	switch(this.onlytype.toLowerCase()){

		case "int":
			if(!isInt(this.value)){
				alert("??????????????????.");

				this.value=(this.oldValue==null?"":this.oldValue);
				return false;
			}
			break;
		case "float":
			if(!isNumeric(this.value)){
				alert("??????????????????.");
				this.value=(this.oldValue==null?"":this.oldValue);
				return false;
			}
			break;
        // ----- Added by linhs 2003-11-5 [begin] -----        
		case "alpha":
			if(!isAlpha(this.value) && (this.value.length!=0)){
				alert("??????????????????????.");
				this.value=(this.oldValue==null?"":this.oldValue);
				return false;
			}
			break;
        // ----- Added by linhs 2003-11-5 [begin] -----        
	}

}

//??????????????????????onfocus="checkTextBoxInput()"??
function checkTextBoxInput(){
	var txtBox=event.srcElement;
	if(txtBox.onlytype){
		if(txtBox.onlytype.toLowerCase()=="date" || txtBox.onlytype.toLowerCase()=="time"
		|| txtBox.onlytype.toLowerCase()=="time1")
		{
			//txtBox.readOnly=true;
			txtBox.ondblclick=setTextBoxDate;
			return true;
		}
		if(txtBox.oldValue==null){
			txtBox.oldValue=txtBox.value;
		}

		txtBox.onkeydown=setBoxInputType;
		try{txtBox.onpaste=checkPasteData;}catch(e){}
		txtBox.onblur=checkInputValue;


	}else{
		return false;
	}

}

//////////////////////////////////////////////


/**********************
*??????????????????
***********************/
function selectDateNoTime() {
	var str=window.showModalDialog(context+"/tdp/js/getdateNoTime.html",null,"font-size:10px;dialogWidth:180px;dialogHeight:180px;scrollbars=no;status=no");
	if (str == null || str == "" || str == "undefined")
		return "";
	else
		return str;
}
function selectDate() {
	var str=window.showModalDialog(context+"/tdp/js/getdate.html",null,	"font-size:10px;dialogWidth:180px;dialogHeight:180px;scrollbars=no;status=no");
	if (str == null || str == "" || str == "undefined")
		return "";
	else
		return str;
 }


function setDate(blFlag)
{
	var bl=true;
	var ret;
	if(blFlag==null){
		bl=true;
	}else{
		bl=blFlag;
	}
	if(event.srcElement.tagName=="INPUT"){
		if(bl){
			ret=selectDateNoTime();
			if(ret!=null && ret!=""){
				event.srcElement.value=ret;
			}
		}else{
			ret=selectDate();
			if(ret!=null && ret!=""){
				event.srcElement.value=ret;
			}
		}
	}
}


// ??????????????(??,??,??),blFlag????0:??,1:??,2:?? ,  add by lbl
function setDatePart(blFlag){
  var strDate=selectDateNoTime();
  if(strDate!=''){
    var arr = strDate.split( "-" );
    var strYear = arr[0];
    var strMonth = arr[1];
    var strDay = arr[2];
    if(blFlag==0){
      event.srcElement.value=strYear;
    }
    if(blFlag==1){
      event.srcElement.value=strMonth;
    }
    if(blFlag==2){
      event.srcElement.value=strDay;
    }
  }
}


function setTextBoxDate()
{
	var bl=true;
	var ret;
	if(this.onlytype.toLowerCase()=="date"){
		bl=true;
	}else if(this.onlytype.toLowerCase()=="time" || this.onlytype.toLowerCase()=="time1"){
		bl=false;
	}
	if(bl){
		ret=selectDateNoTime();
		if(ret!=null && ret!=""){
			this.value=ret;
		}
	}else{
		ret=selectDate();
		if(ret!=null && ret!=""){
			this.value=ret;
		}
	}
}

//////////////////////////////
/*
??????????????
??????????????????????onfocus="setMaxLen()"??
*/
function setMaxLen(len){
	var txtObj=event.srcElement;
	txtObj.lenValue=null;

	if(txtObj.tagName!="TEXTAREA") return;

	if(txtObj.maxlength==null && len==null) return;
	if(len!=null){
		txtObj.lenValue=len;
	}
	if(txtObj.maxlength!=null){			//???????
		txtObj.lenValue=txtObj.maxlength;

	}
	if(txtObj.lenValue!=null){
		if(!isInt(txtObj.lenValue)){
			alert("maxlength?????????????");
			return;
		}else{
			
			txtObj.onkeydown=checkInputTextMaxLen;
			try{
			txtObj.onpaste=checkPasteTextMaxLen;
			
			}catch(e){}
			txtObj.onblur=checkTextAreaValueLen;
			
		
			return;
			
		}

	}else{
		return;
	}
}

function checkInputTextMaxLen(){
	var code=event.keyCode;
	
	if(code==190 ||  code==46 || code==37 ||  code==39 ||  code==8 ||  code==40 || code==17 ) 
		return true;
	if(this.value.length>=this.lenValue) return false;
	
}
function checkPasteTextMaxLen(){
	var pasteData=window.clipboardData.getData('Text');

	if(pasteData.length>this.lenValue){
		alert("????????????????????????????????");
		return false;
	}
	
}
function checkTextAreaValueLen(){
	if(this.value.length>this.lenValue){
		alert("?????????????????????????");
		this.value=this.value.substring(0,this.lenValue);
		return false;
	}
	
}
//??????????????



// ????? ??????????? add by linhs (2004-03-12)
function formatTime1(strValue)
{
	// ???????????? 2001-10-1/2001-1-10 ???????
	if( isEmpty( strValue ) ) return "";

	var arr=strValue.split(" ");
	var arr1 = arr[0].split( "-" );
	var year = arr1[0];
	var month = arr1[1];
	var day = arr1[2];
	var arr2=arr[1].split(":");
	var hour=arr2[0];
	var minute=arr2[1];
	var second=arr2[2];

	// 1 <= ??? <= 12??1 <= ???? <= 31
	if( month<10 && month.length == 1)
		month = '0' + month;

	if( day<10 && day.length == 1)
		day = '0' + day;

	// 1 <= ??? <= 12??1 <= ???? <= 31
	if( hour<10 && hour.length == 1)
		hour = '0' + hour;

	// 1 <= ??? <= 12??1 <= ???? <= 31
	if( minute<10 && minute.length == 1)
		minute = '0' + minute;

	// 1 <= ??? <= 12??1 <= ???? <= 31
	if( second<10 && second.length == 1)
		second = '0' + second;

    //alert(year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second);
	return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second;
}

// ????? ???????????? add by linhs (2004-03-31)
function formatDate(strValue)
{
	// ???????????? 2001-10-1/2001-1-10 ???????
	if( isEmpty( strValue ) ) return "";

	var arr=strValue.split(" ");
	var arr1 = arr[0].split( "-" );
	var year = arr1[0];
	var month = arr1[1];
	var day = arr1[2];

	// 1 <= ??? <= 12??1 <= ???? <= 31
	if( month<10 && month.length == 1)
		month = '0' + month;

	if( day<10 && day.length == 1)
		day = '0' + day;

	return year + '-' + month + '-' + day;
}