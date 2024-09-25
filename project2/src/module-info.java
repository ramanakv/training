
module trg.mod2 {
	
	requires trg.mod1;
	requires java.sql;  // module name
	
	exports trg.mod2.pkg1;   // package name
	
}