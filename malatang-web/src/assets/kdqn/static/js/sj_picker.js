
// jshint ignore: start
+function($){

$.rawCitiesData = [{"name":"星期","code":"","sub":[{"name":"开始","code":"","sub":[{"name":"结束","code":""}]}]},{"name":"星期一","code":1,"sub":[{"name":"第1节","code":1,"sub":[{"name":"到第1节","code":1},{"name":"到第2节","code":2},{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第2节","code":2,"sub":[{"name":"到第2节","code":2},{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第3节","code":3,"sub":[{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第4节","code":4,"sub":[{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第5节","code":5,"sub":[{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第6节","code":6,"sub":[{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第7节","code":7,"sub":[{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第8节","code":8,"sub":[{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第9节","code":9,"sub":[{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第10节","code":10,"sub":[{"name":"到第10节","code":10}]}]},{"name":"星期二","code":2,"sub":[{"name":"第1节","code":1,"sub":[{"name":"到第1节","code":1},{"name":"到第2节","code":2},{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第2节","code":2,"sub":[{"name":"到第2节","code":2},{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第3节","code":3,"sub":[{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第4节","code":4,"sub":[{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第5节","code":5,"sub":[{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第6节","code":6,"sub":[{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第7节","code":7,"sub":[{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第8节","code":8,"sub":[{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第9节","code":9,"sub":[{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第10节","code":10,"sub":[{"name":"到第10节","code":10}]}]},{"name":"星期三","code":3,"sub":[{"name":"第1节","code":1,"sub":[{"name":"到第1节","code":1},{"name":"到第2节","code":2},{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第2节","code":2,"sub":[{"name":"到第2节","code":2},{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第3节","code":3,"sub":[{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第4节","code":4,"sub":[{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第5节","code":5,"sub":[{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第6节","code":6,"sub":[{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第7节","code":7,"sub":[{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第8节","code":8,"sub":[{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第9节","code":9,"sub":[{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第10节","code":10,"sub":[{"name":"到第10节","code":10}]}]},{"name":"星期四","code":4,"sub":[{"name":"第1节","code":1,"sub":[{"name":"到第1节","code":1},{"name":"到第2节","code":2},{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第2节","code":2,"sub":[{"name":"到第2节","code":2},{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第3节","code":3,"sub":[{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第4节","code":4,"sub":[{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第5节","code":5,"sub":[{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第6节","code":6,"sub":[{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第7节","code":7,"sub":[{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第8节","code":8,"sub":[{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第9节","code":9,"sub":[{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第10节","code":10,"sub":[{"name":"到第10节","code":10}]}]},{"name":"星期五","code":5,"sub":[{"name":"第1节","code":1,"sub":[{"name":"到第1节","code":1},{"name":"到第2节","code":2},{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第2节","code":2,"sub":[{"name":"到第2节","code":2},{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第3节","code":3,"sub":[{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第4节","code":4,"sub":[{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第5节","code":5,"sub":[{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第6节","code":6,"sub":[{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第7节","code":7,"sub":[{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第8节","code":8,"sub":[{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第9节","code":9,"sub":[{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第10节","code":10,"sub":[{"name":"到第10节","code":10}]}]},{"name":"星期六","code":6,"sub":[{"name":"第1节","code":1,"sub":[{"name":"到第1节","code":1},{"name":"到第2节","code":2},{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第2节","code":2,"sub":[{"name":"到第2节","code":2},{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第3节","code":3,"sub":[{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第4节","code":4,"sub":[{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第5节","code":5,"sub":[{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第6节","code":6,"sub":[{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第7节","code":7,"sub":[{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第8节","code":8,"sub":[{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第9节","code":9,"sub":[{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第10节","code":10,"sub":[{"name":"到第10节","code":10}]}]},{"name":"星期日","code":7,"sub":[{"name":"第1节","code":1,"sub":[{"name":"到第1节","code":1},{"name":"到第2节","code":2},{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第2节","code":2,"sub":[{"name":"到第2节","code":2},{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第3节","code":3,"sub":[{"name":"到第3节","code":3},{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第4节","code":4,"sub":[{"name":"到第4节","code":4},{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第5节","code":5,"sub":[{"name":"到第5节","code":5},{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第6节","code":6,"sub":[{"name":"到第6节","code":6},{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第7节","code":7,"sub":[{"name":"到第7节","code":7},{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第8节","code":8,"sub":[{"name":"到第8节","code":8},{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第9节","code":9,"sub":[{"name":"到第9节","code":9},{"name":"到第10节","code":10}]},{"name":"第10节","code":10,"sub":[{"name":"到第10节","code":10}]}]}];
}($);
// jshint ignore: end

/* global $:true */
/* jshint unused:false*/

+ function($) {
  "use strict";

  var defaults;
  var raw = $.rawCitiesData;

  var format = function(data) {
    var result = [];
    for(var i=0;i<data.length;i++) {
      var d = data[i];
      if(/^请选择|市辖区/.test(d.name)) continue;
      result.push(d);
    }
    if(result.length) return result;
    return [];
  };

  var sub = function(data) {
    if(!data.sub) return [{ name: '', code: data.code }];  // 有可能某些县级市没有区
    return format(data.sub);
  };

  var getCities = function(d) {
    for(var i=0;i< raw.length;i++) {
      if(raw[i].code === d || raw[i].name === d) return sub(raw[i]);
    }
    return [];
  };

  var getDistricts = function(p, c) {
    for(var i=0;i< raw.length;i++) {
      if(raw[i].code === p || raw[i].name === p) {
        for(var j=0;j< raw[i].sub.length;j++) {
          if(raw[i].sub[j].code === c || raw[i].sub[j].name === c) {
            return sub(raw[i].sub[j]);
          }
        }
      }
    }
  };

  var parseInitValue = function (val) {
    var p = raw[0], c, d;
    var tokens = val.split(' ');
    raw.map(function (t) {
      if (t.name === tokens[0]) p = t;
    });

    p.sub.map(function (t) {
      if (t.name === tokens[1]) c = t;
    })

    if (tokens[2]) {
      c.sub.map(function (t) {
        if (t.name === tokens[2]) d = t;
      })
    }

    if (d) return [p.code, c.code, d.code];
    return [p.code, c.code];
  }

  $.fn.cityPicker = function(params) {
    params = $.extend({}, defaults, params);
    return this.each(function() {
      var self = this;
      
      var provincesName = raw.map(function(d) {
        return d.name;
      });
      var provincesCode = raw.map(function(d) {
        return d.code;
      });
      var initCities = sub(raw[0]);
      var initCitiesName = initCities.map(function (c) {
        return c.name;
      });
      var initCitiesCode = initCities.map(function (c) {
        return c.code;
      });
      var initDistricts = sub(raw[0].sub[0]);

      var initDistrictsName = initDistricts.map(function (c) {
        return c.name;
      });
      var initDistrictsCode = initDistricts.map(function (c) {
        return c.code;
      });

      var currentProvince = provincesName[0];
      var currentCity = initCitiesName[0];
      var currentDistrict = initDistrictsName[0];

      var cols = [
          {
            displayValues: provincesName,
            values: provincesCode,
            cssClass: "col-province"
          },
          {
            displayValues: initCitiesName,
            values: initCitiesCode,
            cssClass: "col-city"
          }
        ];

        if(params.showDistrict) cols.push({
          values: initDistrictsCode,
          displayValues: initDistrictsName,
          cssClass: "col-district"
        });

      var config = {

        cssClass: "city-picker",
        rotateEffect: false,  //为了性能
        formatValue: function (p, values, displayValues) {
          return displayValues.join(' ');
        },
        onChange: function (picker, values, displayValues) {
          var newProvince = picker.cols[0].displayValue;
          var newCity;
          if(newProvince !== currentProvince) {
            var newCities = getCities(newProvince);
            newCity = newCities[0].name;
            var newDistricts = getDistricts(newProvince, newCity);
            picker.cols[1].replaceValues(newCities.map(function (c) {
              return c.code;
            }), newCities.map(function (c) {
              return c.name;
            }));
            if(params.showDistrict) picker.cols[2].replaceValues(newDistricts.map(function (d) {
              return d.code;
            }), newDistricts.map(function (d) {
              return d.name;
            }));
            currentProvince = newProvince;
            currentCity = newCity;
            picker.updateValue();
            return false; // 因为数据未更新完，所以这里不进行后序的值的处理
          } else {
            if(params.showDistrict) {
              newCity = picker.cols[1].displayValue;
              if(newCity !== currentCity) {
                var districts = getDistricts(newProvince, newCity);
                picker.cols[2].replaceValues(districts.map(function (d) {
                  return d.code;
                }), districts.map(function (d) {
                  return d.name;
                }));
                currentCity = newCity;
                picker.updateValue();
                return false; // 因为数据未更新完，所以这里不进行后序的值的处理
              }
            }
          }
          //如果最后一列是空的，那么取倒数第二列
          var len = (values[values.length-1] ? values.length - 1 : values.length - 2)
          $(self).attr('data-code', values[len]);
          $(self).attr('data-codes', values.join(','));
          if (params.onChange) {
            params.onChange.call(self, picker, values, displayValues);
          }
        },

        cols: cols
      };

      if(!this) return;
      var p = $.extend({}, params, config);
      //计算value
      var val = $(this).val();
      if (!val) val = '星期 开始 结束';
      currentProvince = val.split(" ")[0];
      currentCity = val.split(" ")[1];
      currentDistrict= val.split(" ")[2];
      if(val) {
        p.value = parseInitValue(val);
        if(p.value[0]) {
          var cities = getCities(p.value[0]);
          p.cols[1].values = cities.map(function (c) {
            return c.code;
          });
          p.cols[1].displayValues = cities.map(function (c) {
            return c.name;
          });
        }

        if(p.value[1]) {
          if (params.showDistrict) {
            var dis = getDistricts(p.value[0], p.value[1]);
            p.cols[2].values = dis.map(function (d) {
              return d.code;
            });
            p.cols[2].displayValues = dis.map(function (d) {
              return d.name;
            });
          }
        } else {
          if (params.showDistrict) {
            var dis = getDistricts(p.value[0], p.cols[1].values[0]);
            p.cols[2].values = dis.map(function (d) {
              return d.code;
            });
            p.cols[2].displayValues = dis.map(function (d) {
              return d.name;
            });
          }
        }
      }
      $(this).picker(p);
    });
  };

  defaults = $.fn.cityPicker.prototype.defaults = {
    showDistrict: true //是否显示地区选择
  };

}($);