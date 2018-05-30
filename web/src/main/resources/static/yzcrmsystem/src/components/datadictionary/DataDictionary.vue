<template>
  <div style="position: relative">
    <Modal
      v-model="addDataDictionary"
      @on-ok="saveDataDictionary"
      @on-cancel="closeAddDataDictionary"
      ok-text="保存"
      cancel-text="取消"
      title="新增数据字典项">
      <Form ref="datadictionaryEntity" :model="datadictionaryEntity" :label-width="80">
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="category" label="类目代码">
              <Input type="text" placeholder="请输入" v-model="datadictionaryEntity.category"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="categoryDesc" label="类目名称">
              <Input type="text" placeholder="请输入" v-model="datadictionaryEntity.categoryDesc"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="itemCode" label="项目代码">
              <Input type="text" placeholder="请输入" v-model="datadictionaryEntity.itemCode"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="itemName" label="项目名称">
              <Input type="text" placeholder="请输入" v-model="datadictionaryEntity.itemName"></Input>
            </FormItem>
          </Col>
        </Row>
      </Form>
    </Modal>
    <Modal
      v-model="alterDataDictionarybox"
      @on-ok="modifyDataDictionary"
      @on-cancel="closealterDataDictionary"
      ok-text="保存"
      cancel-text="取消"
      title="修改数据字典项">
      <Form ref="alterdatadictionaryEntity" :model="alterdatadictionaryEntity" :label-width="80">
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="category" label="类目代码">
              <Input type="text" v-model="alterdatadictionaryEntity.category"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="categoryDesc" label="类目名称">
              <Input type="text" v-model="alterdatadictionaryEntity.categoryDesc"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="itemCode" label="项目代码">
              <Input type="text" v-model="alterdatadictionaryEntity.itemCode"></Input>
            </FormItem>
          </Col>
        </Row>
        <Row class="row-line40">
          <Col span="24">
            <FormItem prop="itemName" label="项目名称">
              <Input type="text" v-model="alterdatadictionaryEntity.itemName"></Input>
            </FormItem>
          </Col>
        </Row>
      </Form>
    </Modal>
    <Layout class="searchBox">
      <Form ref="searchinfo" :model="searchinfo" :label-width="80">
        <Row :gutter="16" type="flex" justify="center" align="middle" class="row-line">
          <Col span="4">
            <FormItem prop="category" label="类目代码：">
              <Input type="text" v-model="searchinfo.category"></Input>
            </FormItem>
          </Col>
          <Col span="4">
            <FormItem prop="categoryDesc" label="类目名称：">
              <Input type="text" v-model="searchinfo.categoryDesc"></Input>
            </FormItem>
          </Col>
          <Col span="4">
            <FormItem prop="itemCode" label="项目代码：">
              <Input type="text" v-model="searchinfo.itemCode"></Input>
            </FormItem>
          </Col>
          <Col span="4">
            <FormItem prop="itemName" label="项目名称：">
              <Input type="text" v-model="searchinfo.itemName"></Input>
            </FormItem>
          </Col>
          <Col span="2" >
            <Form-item>
              <Button type="primary" v-on:click="queryDataDictionary()">查询</Button>
            </Form-item>
          </Col>
        </Row>
      </Form>
    </Layout>
    <Layout style="margin-top: 20px;">
      <Row type="flex" justify="start" align="middle" class="row-line">
        <Col span="2">数据字典列表</Col>
        <Col span="2" offset="20"><span @click="showAddDataDictionary()"> <Icon type="ios-plus" size="24" color="#25e634" ></Icon> </span></Col>
      </Row>
      <Table :columns="columns" :data="datadictionaryinfo"></Table>
    </Layout>
    <Spin fix v-if="spinShow">
      加载中...
      <spinner></spinner>
    </Spin>
  </div>
</template>

<script>

import Spinner from '../common/Spinner'

export default {
  components: {Spinner},
  name: 'data-dictionary',
  data () {
    return {
      spinShow: true,
      addDataDictionary: false,
      alterDataDictionarybox: false,
      searchinfo: {
        category: '',
        categoryDesc: '',
        itemCode: '',
        itemName: ''
      },
      columns: [
        {
          title: '类目代码',
          key: 'category'
        }, {
          title: '类目名称',
          key: 'categoryDesc'
        }, {
          title: '项目代码',
          key: 'itemCode'
        }, {
          title: '项目名称',
          key: 'itemName'
        }, {
          title: '操作',
          key: 'action',
          width: 150,
          align: 'center',
          render: (h, params) => {
            return h('div', [
              h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click: () => {
                    this.alterDataDictionarybox = true
                    this.alterdatadictionaryEntity.id = params.row.id
                    this.alterdatadictionaryEntity.category = params.row.category
                    this.alterdatadictionaryEntity.categoryDesc = params.row.categoryDesc
                    this.alterdatadictionaryEntity.itemCode = params.row.itemCode
                    this.alterdatadictionaryEntity.itemName = params.row.itemName
                  }
                }
              }, '编辑'),
              h('Button', {
                props: {
                  type: 'error',
                  size: 'small'
                },
                on: {
                  click: () => {
                    this.removeDataDictionary(params.row.id)
                  }
                }
              }, '删除')
            ])
          }
        }
      ],
      datadictionaryinfo: [],
      ss: {
        body: {}
      },
      datadictionaryEntity: {
        category: null,
        categoryDesc: null,
        itemCode: null,
        itemName: null,
        parentId: null,
        status: null
      },
      delId: {
        id: null
      },
      alterdatadictionaryEntity: {
        id: null,
        category: null,
        categoryDesc: null,
        itemCode: null,
        itemName: null,
        parentId: null,
        status: null
      }
    }
  },
  methods: {
    queryDataDictionary () {
      if (!this.spinShow) {
        this.spinShow = true
      }
      this.$http.post('/api/datadictionary/getDataDictionaryList', this.searchinfo, this.ss).then(response => {
        this.datadictionaryinfo = response.body.info
      }, response => {
        // console.info(response.body)
      })
      this.spinShow = false
    },
    showAddDataDictionary () {
      this.addDataDictionary = true
    },
    saveDataDictionary () {
      this.spinShow = true
      this.$http.post('/api/datadictionary/addDataDictionary', this.datadictionaryEntity, this.ss).then(response => {
        // console.info(response)
        if (response.ok) {
          this.queryDataDictionary()
          // this.datadictionaryEntity.forEach((K) => {
          //   this.datadictionaryEntity[K] = null
          // })
          this.$Message.info('新增成功')
        } else {
          this.$Message.info('新增失败')
        }
      }, response => {
        // console.info(response)
        if (response.ok) {
          this.queryDataDictionary()
          // this.datadictionaryEntity.forEach((K) => {
          //   this.datadictionaryEntity[K] = null
          // })
          this.$Message.info('新增成功')
        } else {
          this.$Message.info('新增失败')
        }
      })
      this.spinShow = false
    },
    closeAddDataDictionary () {
      this.$Message.info('取消新增')
    },
    removeDataDictionary (id) {
      this.spinShow = true
      this.delId.id = id
      console.info(this.delId.id)
      this.$http.post('/api/datadictionary/removeDataDictionaryById', this.delId, this.ss).then(response => {
        if (response.ok) {
          this.queryDataDictionary()
          this.$Message.info('删除成功')
        } else {
          this.$Message.info('删除失败')
        }
      }, response => {
        if (response.ok) {
          this.queryDataDictionary()
          this.$Message.info('删除成功')
        } else {
          this.$Message.info('删除失败')
        }
      })
      this.spinShow = false
      // console.log(this.spinShow)
    },
    modifyDataDictionary () {
      this.spinShow = true
      // console.info(this.alterdatadictionaryEntity)
      this.$http.post('/api/datadictionary/alterDataDictionaryById', this.alterdatadictionaryEntity, this.ss).then(response => {
        if (response.ok) {
          this.queryDataDictionary()
          // this.datadictionaryEntity.forEach((K) => {
          //   this.datadictionaryEntity[K] = null
          // })
          this.$Message.info('编辑成功')
        } else {
          this.$Message.info('编辑失败')
        }
        // console.info(response)
      }, response => {
        // console.info(response)
        if (response.ok) {
          this.queryDataDictionary()
          this.$Message.info('编辑成功')
        } else {
          this.$Message.info('编辑失败')
        }
      })
      this.spinShow = false
    },
    closealterDataDictionary () {
      this.$Message.info('取消编辑')
    }
  },
  mounted: function () {
    this.queryDataDictionary()
    this.spinShow = false
    // this.http.post('http://127.0.0.1:8080/datadictionary/getDataDictionaryList', {}, this.ss)
    // console.info(httppost())
    // this.datadictionaryinfo = this.httppost('/datadictionary/getDataDictionaryList', this.ss)
    // console.info(this.datadictionaryinfo)
  }
}
</script>
<style scoped>
.searchBox{
  /*border-bottom: 1px #dddee1 solid;*/
  width: 100%;
}
.margintop24{
  margin-top: 24px;
}
.ivu-form-item {
  margin-bottom: 0px;
  vertical-align: top;
  zoom: 1;
}
  .row-line{
    height: 60px;
  }
  .row-line40{
    height: 40px;
  }
.demo-spin-icon-load{
  animation: ani-demo-spin 1s linear infinite;
}
@keyframes ani-demo-spin {
  from { transform: rotate(0deg);}
  50%  { transform: rotate(180deg);}
  to   { transform: rotate(360deg);}
}
.demo-spin-col{
  height: 100px;
  position: relative;
  border: 1px solid #eee;
}
</style>
