if [ -z "$(which Rscript)" ]; then
  apt-get install r-base
fi
R -q -e 'if(!require(jsonlite)) install.packages("jsonlite", repos="http://cran.us.r-project.org")'
R -q -e 'if(!require(clValid)) install.packages("clValid", repos="http://cran.us.r-project.org")'
R -q -e 'if(!require(amap)) install.packages("amap", repos="http://cran.us.r-project.org")'
R -q -e 'if(!require(sp)) install.packages("sp", repos="http://cran.us.r-project.org")'
R -q -e 'if(!require(ape)) install.packages("ape", repos="http://cran.us.r-project.org")'
