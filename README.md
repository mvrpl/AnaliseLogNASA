# AnaliseLogNASA

### Versão Spark = 2.4.4
### Versão Scala = 2.11.12

#### BUILD .jar:
```bash
scalac -classpath $(find /usr/local/Cellar/apache-spark/2.4.4/libexec/jars -name "*.jar" -type f | paste -sd ":" -) QuestoesLogNASA.scala -d QuestoesLogNASA.jar
```

#### EXECUCAO:
```bash
spark-submit --class mvrpl.me.QuestoesLogNASA --master "local[*]" QuestoesLogNASA.jar
```

## Resultado:
HOSTS UNICOS: 138010

TOTAL ERROS 404: 20868

TOP 5 URLs 404:<br />
(hoohoo.ncsa.uiuc.edu,251)<br />
(piweba3y.prodigy.com,157)<br />
(jbiagioni.npt.nuwc.navy.mil,132)<br />
(piweba1y.prodigy.com,114)<br />
(www-d4.proxy.aol.com,91)<br />

QTD ERRO 404/DIA:<br />
(1995-09-01,26)<br />
(1995-08-31,551)<br />
(1995-08-30,539)<br />
(1995-08-29,416)<br />
(1995-08-28,406)<br />
(1995-08-27,381)<br />
(1995-08-26,358)<br />
(1995-08-25,419)<br />
(1995-08-24,416)<br />
(1995-08-23,359)<br />
(1995-08-22,264)<br />
(1995-08-21,310)<br />
(1995-08-20,306)<br />
(1995-08-19,213)<br />
(1995-08-18,257)<br />
(1995-08-17,276)<br />
(1995-08-16,253)<br />
(1995-08-15,324)<br />
(1995-08-14,297)<br />
(1995-08-13,220)<br />
(1995-08-12,176)<br />
(1995-08-11,272)<br />
(1995-08-10,303)<br />
(1995-08-09,284)<br />
(1995-08-08,395)<br />
(1995-08-07,524)<br />
(1995-08-06,378)<br />
(1995-08-05,237)<br />
(1995-08-04,349)<br />
(1995-08-03,287)<br />
(1995-08-01,243)<br />
(1995-07-28,105)<br />
(1995-07-27,330)<br />
(1995-07-26,344)<br />
(1995-07-25,471)<br />
(1995-07-24,318)<br />
(1995-07-23,231)<br />
(1995-07-22,190)<br />
(1995-07-21,338)<br />
(1995-07-20,419)<br />
(1995-07-19,646)<br />
(1995-07-18,465)<br />
(1995-07-17,420)<br />
(1995-07-16,238)<br />
(1995-07-15,252)<br />
(1995-07-14,414)<br />
(1995-07-13,531)<br />
(1995-07-12,463)<br />
(1995-07-11,493)<br />
(1995-07-10,379)<br />
(1995-07-09,348)<br />
(1995-07-08,317)<br />
(1995-07-07,578)<br />
(1995-07-06,657)<br />
(1995-07-05,475)<br />
(1995-07-04,369)<br />
(1995-07-03,461)<br />
(1995-07-02,274)<br />
(1995-07-01,303)<br />

TOTAL BYTES: 65524307881
